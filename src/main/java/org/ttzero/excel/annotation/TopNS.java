/*
 * Copyright (c) 2017, guanquan.wang@yandex.com All Rights Reserved.
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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Top namespace
 *
 * @author guanquan.wang on 2017/9/21.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TopNS {
    /**
     * Specify the namespace prefix, it will mapping the {@link #uri()} values.
     *
     * @return prefix key array
     */
    String[] prefix();

    /**
     * Setting the namespace uri
     *
     * @return uri array
     */
    String[] uri() default {};

    /**
     * Setting the tag name
     *
     * @return the tag name
     */
    String value();
}
