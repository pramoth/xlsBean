/*
 * Copyright 2013 pramoth.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package th.co.geniustree.lib.xlsbean;

import com.google.common.collect.Table;
import java.util.LinkedHashSet;

/**
 *
 * @author pramoth
 */
public class CsvModelHolder {

    private LinkedHashSet<String> header;
    Table<Integer, String, String> table;

    public LinkedHashSet<String> getHeader() {
        return header;
    }

    public void setHeader(LinkedHashSet<String> header) {
        this.header = header;
    }

    public Table<Integer, String, String> getTable() {
        return table;
    }

    public void setTable(Table<Integer, String, String> table) {
        this.table = table;
    }
}
