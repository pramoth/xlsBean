/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.lib.xlsbean;

import th.co.geniustree.lib.xlsbean.annotation.XlsColumn;
import com.google.common.collect.Table;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Pramoth Suwanpech
 *
 */
public class XlsBean {

    /**
     *
     * @param <>> type of beans
     * @param t
     * @param in
     * @return a list of bean that map .xls file.
     * @throws Exception
     */
    public static <T> List<T> toBeans(Class<T> t, InputStream in, boolean caseInsensitive, Reader reader) throws Exception {
        List<T> tList = new ArrayList<T>();
        CsvModelHolder readCsv = null;
        if (reader == null) {
            readCsv = XlsReaderUtils.readCsv(in, caseInsensitive);
        } else {
            readCsv = CsvReaderUtils.readCsv(reader, caseInsensitive);
        }
        LinkedHashSet<String> header = readCsv.getHeader();
        Table<Integer, String, String> table = readCsv.getTable();
        for (int i = 0; i < readCsv.getTable().rowKeySet().size(); i++) {
            T model = null;
            List<Field> fields = getAllFields(t);
            for (Field field : fields) {
                if (model == null) {
                    model = t.newInstance();
                    tList.add(model);
                }
                XlsColumn annotation = field.getAnnotation(XlsColumn.class);
                if (annotation != null) {
                    field.setAccessible(true);
                    String columnName = caseInsensitive ? annotation.columnName().toUpperCase() : annotation.columnName();
                    if (header.contains(columnName)) {
                        char[] stringArray = field.getName().toCharArray();
                        stringArray[0] = Character.toUpperCase(stringArray[0]);
                        String uperCaseName = new String(stringArray);
                        Method declaredMethod = t.getMethod("set" + uperCaseName, String.class);
                        declaredMethod.invoke(model, table.row(i).get(columnName));
                    } else {
                        throw new ColumnNotFoundException("Xls's column name not found on xls file. Column '" + columnName + "'", columnName);
                    }
                }
            }
        }
        return tList;
    }

    public static <T> List<T> toBeans(Class<T> t, InputStream in) throws Exception {
        return toBeans(t, in, true, null);
    }

    public static <T> List<T> csvToBeans(Class<T> t, Reader in) throws Exception {
        return toBeans(t, null, true, in);
    }

    /**
     *
     * @param <>> beans type.
     * @param sheetName a xls sheet name.
     * @param beans a beans to write back to .xls file.
     * @param out output xls.(Note. you must explicit close out on yourself.
     * @param type XLS or XLSX
     * @throws Exception
     */
    public static <T> void toXls(String sheetName, Collection<T> beans, OutputStream out, Type type) throws Exception {
        if (beans.isEmpty()) {
            return;
        }
        Workbook wb = null;
        if (type == Type.XLS) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
        CreationHelper createHelper = wb.getCreationHelper();
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("d/m/yyyy"));
        Sheet sheet = wb.createSheet(sheetName);
        List<Field> fields = null;
        int rowNum = 0;
        for (T t : beans) {
            if (fields == null) {
                fields = getAllFields(t.getClass());
            }
            int cellNum = 0;
            if (rowNum == 0) {
                Row row = sheet.createRow(rowNum);
                for (Field field : fields) {
                    XlsColumn annotation = field.getAnnotation(XlsColumn.class);
                    if (annotation != null) {
                        row.createCell(cellNum).setCellValue(annotation.columnName());
                    }
                    cellNum++;
                }
                rowNum++;
                cellNum = 0;
            }
            Row row = sheet.createRow(rowNum);
            for (Field field : fields) {
                XlsColumn annotation = field.getAnnotation(XlsColumn.class);
                if (annotation != null) {
                    char[] stringArray = field.getName().toCharArray();
                    stringArray[0] = Character.toUpperCase(stringArray[0]);
                    String uperCaseName = new String(stringArray);
                    Method declaredMethod = t.getClass().getMethod("get" + uperCaseName);
                    Object value = declaredMethod.invoke(t);
                    Class<?> returnType = declaredMethod.getReturnType();
                    if (value != null) {
                        if (returnType.isAssignableFrom(Date.class)) {
                            Cell createCell = row.createCell(cellNum, Cell.CELL_TYPE_NUMERIC);
                            createCell.setCellStyle(cellStyle);
                            createCell.setCellValue((Date) value);
                        } else {
                            row.createCell(cellNum).setCellValue(value.toString());
                        }
                    }
                }
                cellNum++;
            }
            rowNum++;
        }
        wb.write(out);
        out.flush();
    }

    private static List<Field> getAllFields(Class clazz) {
        return getAllFieldsRec(clazz, new ArrayList<Field>());
    }

    private static List<Field> getAllFieldsRec(Class clazz, List<Field> vector) {
        Class superClazz = clazz.getSuperclass();
        if (superClazz != null) {
            getAllFieldsRec(superClazz, vector);
        }
        vector.addAll(Arrays.asList(clazz.getDeclaredFields()));
        return vector;
    }
}
