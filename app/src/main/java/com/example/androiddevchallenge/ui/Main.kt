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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.Constans
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Detail
import com.example.androiddevchallenge.ui.bg.MoonBackground
import com.example.androiddevchallenge.ui.bg.SunnyBackground
import com.example.androiddevchallenge.ui.theme.MyThemedPreview

@Composable
fun Main() {

    val scrollState = rememberScrollState()

    val data = Constans.beijingDetail

    val fillSize = Modifier.fillMaxSize()

    if (isSystemInDarkTheme()) {
        MoonBackground(fillSize)
    } else {
        SunnyBackground(fillSize)
    }

    Box {
        Title(
            Modifier
                .padding(top = 80.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            data,
        )

        Header(data, scrollState.value)

        Body(data, scrollState)
    }
}

private val BodyPadding = 260.dp
private val HeaderPadding = 120.dp
private val titleSpacing = 100.dp

@Composable
fun Title(
    modifier: Modifier,
    detail: Detail
) {

    Box(modifier = modifier) {

        // Top location name
        val currentLocationDesc =
            "${stringResource(R.string.current_location)} ${detail.locationName},"
        Row(
            modifier = Modifier
                .align(Alignment.TopStart)
                .semantics(mergeDescendants = true) {
                    contentDescription = currentLocationDesc
                },
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Text(
                modifier = Modifier.padding(start = 10.dp),
                text = detail.locationName,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@Composable
fun Header(detail: Detail, scroll: Int) {

    val range = with(LocalDensity.current) { (BodyPadding - HeaderPadding).toPx() }
    val alpha = 1 - (scroll / range).coerceAtMost(1f)

    Column(
        Modifier
            .padding(start = 30.dp)
            .alpha(alpha)
            .graphicsLayer {
                translationY = -scroll.toFloat()
            }
    ) {

        Spacer(modifier = Modifier.height(HeaderPadding))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "${detail.temperature.current}°",
                style = MaterialTheme.typography.h1
            )
            Text(text = "Sunny", fontSize = 30.sp, style = MaterialTheme.typography.h4)
        }

        Row(Modifier.padding(horizontal = 10.dp, vertical = 20.dp)) {

            // Humidity percent
            val humidityDesc = "${stringResource(id = R.string.humidity)}: ${detail.humidity}"
            Column(
                modifier = Modifier
                    .semantics(true) { contentDescription = humidityDesc },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = detail.humidity)
                Text(
                    text = stringResource(id = R.string.humidity),
                    style = MaterialTheme.typography.caption
                )
            }
        }
    }
}

@Composable
fun Body(detail: Detail, scrollState: ScrollState) {

    Column(
        Modifier
            .padding(start = 15.dp, end = 15.dp, top = titleSpacing)
            .verticalScroll(scrollState)
    ) {

        Spacer(modifier = Modifier.padding(top = BodyPadding))

        ForecastCard(list = detail.futureDayForecast)
    }
}

@Preview
@Composable
fun MainLightPreview() {
    MyThemedPreview {
        Main()
    }
}

@Preview
@Composable
fun MainDarkPreview() {
    MyThemedPreview(true) {
        Main()
    }
}
