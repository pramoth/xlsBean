/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.lib.xlsbean;

import com.google.common.base.Splitter;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.io.CharStreams;
import com.google.common.io.InputSupplier;
import com.oracle.jrockit.jfr.ContentType;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.*;

/**
 *
 * @author Teng
 */
public class CsvReaderUtils {

    public static CsvModelHolder readCsv(final Reader reader, boolean caseInsensitive) throws IOException {
        CsvModelHolder holder = new CsvModelHolder();
        List<String> header = new ArrayList<String>();
        Table<Integer, String, String> table = HashBasedTable.create();
        List<String> rowIter = CharStreams.readLines(new InputSupplier<Reader>() {

            public Reader getInput() throws IOException {
                return reader;
            }
        });

        int index = 0;
        for (String rowString : rowIter) {
            Iterable<String> row = Splitter.on(',').trimResults().split(rowString);
            if (index == 0) {
                for (String head : row) {
                    if (caseInsensitive) {
                        header.add(head.toString().toUpperCase());
                    } else {
                        header.add(head.toString());
                    }
                }

            } else {
                int columnIndex = 0;
                for (String data : row) {
                    if (columnIndex >= header.size()) {
                        continue;
                    }
                    table.put(index - 1, header.get(columnIndex), data);
                    columnIndex++;
                }
            }
            holder.setHeader(new LinkedHashSet<String>(header));
            holder.setTable(table);
            index++;
        }
        return holder;
    }
}
