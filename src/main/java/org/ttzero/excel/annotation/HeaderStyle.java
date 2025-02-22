/*
 * Copyright (c) 2017-2021, carl.jia@qq.com All Rights Reserved.
 * Copyright (c) 2017-2021, guanquan.wang@yandex.com All Rights Reserved.
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


package org.ttzero.excel.annotation;

import org.ttzero.excel.entity.style.Fill;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom header styles
 *
 * @author jialei2 at 2021-05-10 17:38
 * @author guanquan.wang at 2021-08-06 18:19
 */
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HeaderStyle {

    /**
     * Set font color.
     *
     * @return color
     */
    String fontColor() default "white";

    /**
     * Set the foreground color.
     *
     * @see Fill#parse(java.lang.String)
     * @return color
     */
    String fillFgColor() default "#666699";
}
