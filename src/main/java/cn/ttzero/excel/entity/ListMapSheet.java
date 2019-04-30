/*
 * Copyright (c) 2019, guanquan.wang@yandex.com All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.ttzero.excel.entity;

import cn.ttzero.excel.reader.Cell;
import cn.ttzero.excel.util.StringUtil;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by guanquan.wang at 2018-01-26 14:46
 */
public class ListMapSheet extends ListSheet {
    private List<Map<String, ?>> data;

    /**
     * Constructor worksheet
     */
    public ListMapSheet() {
        super();
    }

    /**
     * Constructor worksheet
     * @param name the worksheet name
     */
    public ListMapSheet(String name) {
        super(name);
    }

    /**
     * Constructor worksheet
     * @param name the worksheet name
     * @param columns the header info
     */
    public ListMapSheet(String name, final Column[] columns) {
        super(name, columns);
    }

    /**
     * Constructor worksheet
     * @param name the worksheet name
     * @param waterMark the water mark
     * @param columns the header info
     */
    public ListMapSheet(String name, WaterMark waterMark, final Column[] columns) {
        super(name, waterMark, columns);
    }

    public ListMapSheet setData(final List<Map<String, ?>> data) {
        this.data = data;
        return this;
    }

    /**
     * Release resources
     * @throws IOException if io error occur
     */
    @Override
    public void close() throws IOException {
        if (shouldClose) {
            data.clear();
            data = null;
        }
        super.close();
    }

    /**
     * Reset the row-block data
     */
    @Override
    protected void resetBlockData() {
        int end = getEndIndex();
        int len = columns.length;
        for (; start < end; rows++, start++) {
            Row row = rowBlock.next();
            row.index = rows;
            Cell[] cells = row.realloc(len);
            for (int i = 0; i < len; i++) {
                Column hc = columns[i];
                Object e = data.get(start).get(hc.key);
                // clear cells
                Cell cell = cells[i];
                cell.clear();

                // blank cell
                if (e == null) {
                    cell.setBlank();
                    continue;
                }

                setCellValueAndStyle(cell, e, hc);
            }
        }
    }


    /**
     * Returns the header column info
     *
     * @return array of column
     */
    @Override
    public Column[] getHeaderColumns() {
        if (headerReady) return columns;
        @SuppressWarnings("unchecked")
        Map<String, ?> first = (Map<String, ?>) workbook.getFirst(data);
        // No data
        if (first == null) {
            if (columns == null) {
                columns = new Column[0];
            }
        }
        else if (columns.length == 0) {
            int size = first.size(), i = 0;
            columns = new Column[size];
            for (Iterator<? extends Map.Entry<String, ?>> it = first.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, ?> entry = it.next();
                columns[i++] = new Column(entry.getKey(), entry.getKey(), entry.getValue().getClass());
            }
        }
        else {
            for (int i = 0; i < columns.length; i++) {
                Column hc = columns[i];
                if (StringUtil.isEmpty(hc.key)) {
                    throw new ExcelWriteException(getClass() + " 类别必须指定map的key。");
                }
                if (hc.getClazz() == null) {
                    hc.setClazz(first.get(hc.key).getClass());
                }
            }
        }
        for (Column hc : columns) {
            hc.styles = workbook.getStyles();
        }
        headerReady = true;
        return columns;
    }

    /**
     * Paging worksheet
     * @return a copy worksheet
     */
    @Override
    public ListMapSheet copy() {
        ListMapSheet sheet = new ListMapSheet(name, columns);
        sheet.data = data;
        sheet.autoSize = autoSize;
        sheet.autoOdd = autoOdd;
        sheet.oddFill = oddFill;
        sheet.relManager = relManager.clone();
        sheet.sheetWriter = sheetWriter.copy(sheet);
        sheet.waterMark = waterMark;
        sheet.copySheet = true;
        return sheet;
    }

    /**
     * Returns total data size before split
     * @return the total size
     */
    @Override
    protected int dataSize() {
        return data.size();
    }
}
