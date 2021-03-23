/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import com.example.androiddevchallenge.model.Detail
import com.example.androiddevchallenge.model.Simple
import com.example.androiddevchallenge.model.Temperature
import java.util.Date

object Constans {

    val beijingDetail: Detail = Detail(
        locationName = "Kochi",
        temperature = Temperature(
            current = 32,
            min = 28,
            max = 35
        ),
        humidity = "5 %",
        futureDayForecast = listOf(
            Simple(
                date = Date(2021, 2, 22),
                temperature = Temperature(
                    min = 28,
                    max = 33
                )
            ),
            Simple(
                date = Date(2021, 2, 23),
                temperature = Temperature(
                    min = 30,
                    max = 32
                )
            ),
            Simple(
                date = Date(2021, 2, 24),
                temperature = Temperature(
                    min = 27,
                    max = 31
                )
            ),
            Simple(
                date = Date(2021, 2, 25),
                temperature = Temperature(
                    min = 29,
                    max = 34
                )
            ),

            Simple(
                date = Date(2021, 2, 26),
                temperature = Temperature(
                    min = 29,
                    max = 33
                )
            ),

            Simple(
                date = Date(2021, 2, 27),
                temperature = Temperature(
                    min = 28,
                    max = 30
                )
            ),

        ),
    )
}
