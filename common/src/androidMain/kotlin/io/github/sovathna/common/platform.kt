package io.github.sovathna.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

actual fun getPlatformName(): String {
    return "Android"
}

@Composable
actual fun Test() {

}

@Composable
actual fun getPainterResource(res: String): Painter = painterResource(1)