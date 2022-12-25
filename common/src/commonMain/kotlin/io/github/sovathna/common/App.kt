package io.github.sovathna.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun App(viewModel: AbstractAppViewModel) {
    val state by viewModel.state.collectAsState()
    Button(onClick = {
        viewModel.getName()
    }) {
        Text(state)
    }
}

@Composable
fun AppText(
    modifier: Modifier,
    text: String,
    textAlign: TextAlign? = null,
    fontSize: TextUnit = TextUnit.Unspecified
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        fontSize = fontSize,
        letterSpacing = 0.sp
    )
}


@Composable
expect fun getPainterResource(res: String): Painter
