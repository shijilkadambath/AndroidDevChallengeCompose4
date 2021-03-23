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
package com.example.androiddevchallenge.model

class Detail(
    val locationName: String = "",
    val temperature: Temperature = Temperature(),
    val humidity: String,
    val futureDayForecast: List<Simple> = emptyList(),

)

data class Temperature(
    val current: Number? = null,
    val min: Number? = null,
    val max: Number? = null,
)

data class Wind(
    val speed: String,
    val direction: String,
)

data class AQI(
    val value: Number,
    val desc: String
)
