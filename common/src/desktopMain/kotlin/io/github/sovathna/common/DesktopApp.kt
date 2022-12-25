// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.
package io.github.sovathna.common

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Preview
@Composable
fun AppPreview() {
    App(viewModel = remember { AppViewModel() })
}

@Composable
actual fun getPainterResource(res: String): Painter = painterResource(res)