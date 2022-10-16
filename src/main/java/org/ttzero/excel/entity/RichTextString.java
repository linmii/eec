/*
 * Copyright (c) 2017-2022, guanquan.wang@yandex.com All Rights Reserved.
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

import org.ttzero.excel.entity.style.Font;

/**
 * @author guanquan.wang at 2022-10-16 17:06
 */
public class RichTextString {
    public RichTextString() { }

    public RichTextString(String txt) {

    }

    public RichTextString append(String txt) {
        return this;
    }

    public RichTextString append(String txt, Font font) {
        return this;
    }

    public RichTextString addFontInRange(int from, Font font) {
        return this;
    }

    public RichTextString addFontInRange(int from, int end, Font font) {
        return this;
    }

    public RichTextString addFontIfMatch() {
        return this;
    }
}
