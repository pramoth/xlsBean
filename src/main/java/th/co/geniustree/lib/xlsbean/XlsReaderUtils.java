/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.lib.xlsbean;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Teng
 */
public class XlsReaderUtils {

    public static CsvModelHolder readCsv(InputStream in, boolean caseInsensitive) throws IOException, InvalidFormatException {
        CsvModelHolder holder = new CsvModelHolder();
        List<String> header = new ArrayList<String>();
        Table<Integer, String, String> table = HashBasedTable.create();
        Workbook myWorkBook = WorkbookFactory.create(in);
        Sheet mySheet = myWorkBook.getSheetAt(0);
        Iterator rowIter = mySheet.rowIterator();

        int index = 0;
        while (rowIter.hasNext()) {
            if (index == 0) {
                Row myRow = (Row) rowIter.next();
                Iterator<Cell> cellIterator = myRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell next = cellIterator.next();
                    if (caseInsensitive) {
                        header.add(next.toString().toUpperCase());
                    } else {
                        header.add(next.toString());
                    }
                }

            } else {
                Row myRow = (Row) rowIter.next();
                Iterator<Cell> cellIterator = myRow.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell next = cellIterator.next();
                    int columnIndex = next.getColumnIndex();
                    if (columnIndex >= header.size()) {
                        continue;
                    }
                    table.put(index - 1, header.get(columnIndex), next.toString());
                }
            }
            holder.setHeader(new LinkedHashSet<String>(header));
            holder.setTable(table);
            index++;
        }
        return holder;
    }
}
