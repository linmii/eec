/*
 * Copyright (c) 2017-2019, guanquan.wang@yandex.com All Rights Reserved.
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

package org.ttzero.excel.entity;

import java.lang.reflect.Field;
import java.util.Collection;

/**
 * FIXME unfinished
 * @author guanquan.wang at 2019-04-30 20:45
 */
public class CollectionSheet<T> extends Sheet {
    @SuppressWarnings("unused")
	private Collection<T> data;
    @SuppressWarnings("unused")
    private Field[] fields;

    /**
     * Constructor worksheet
     */
    public CollectionSheet() {
        super();
    }

    /**
     * Constructor worksheet
     *
     * @param name the worksheet name
     */
    public CollectionSheet(String name) {
        super(name);
    }

    /**
     * Constructor worksheet
     *
     * @param name the worksheet name
     * @param columns the {@link org.ttzero.excel.entity.Column}
     */
    public CollectionSheet(String name, final org.ttzero.excel.entity.Column... columns) {
        super(name, columns);
    }

    /**
     * Constructor worksheet
     *
     * @param name the worksheet name
     * @param waterMark the {@link WaterMark}
     * @param columns the {@link org.ttzero.excel.entity.Column}
     */
    public CollectionSheet(String name, WaterMark waterMark, final org.ttzero.excel.entity.Column... columns) {
        super(name, waterMark, columns);
    }

    public CollectionSheet<T> setData(final Collection<T> data) {
        this.data = data;
        return this;
    }

    @Override
    protected void resetBlockData() {

    }

}
