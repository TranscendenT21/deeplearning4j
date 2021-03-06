/*-
 *  * Copyright 2016 Skymind, Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 */

package org.datavec.api.transform.analysis.quality.string;

import org.datavec.api.transform.quality.columns.StringQuality;
import org.nd4j.linalg.function.BiFunction;

import java.io.Serializable;

/**
 * Created by Alex on 5/03/2016.
 */
public class StringQualityMergeFunction implements BiFunction<StringQuality, StringQuality, StringQuality>, Serializable {
    @Override
    public StringQuality apply(StringQuality v1, StringQuality v2) {
        return v1.add(v2);
    }
}
