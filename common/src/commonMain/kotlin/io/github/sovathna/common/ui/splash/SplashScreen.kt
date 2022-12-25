package io.github.sovathna.common.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.sovathna.common.AppText
import io.github.sovathna.common.getPainterResource
import kotlinx.coroutines.CoroutineScope
import kotlin.math.ceil

@Composable
fun SplashScreen(
    scope: CoroutineScope = rememberCoroutineScope(),
    viewModel: BaseSplashViewModel,
    onDone: () -> Unit
) {
    val state by viewModel.statesFlow.collectAsState(scope.coroutineContext)
    val currentOnDone by rememberUpdatedState(onDone)

    LaunchedEffect(true) {
        //viewModel.init()
        if (state.isDone) {
            currentOnDone()
        }
    }

    fun numToKhNum(str: String): String {
        var newStr = ""
        str.forEach {
            newStr +=
                when (it) {
                    '1' -> "១"
                    '2' -> "២"
                    '3' -> "៣"
                    '4' -> "៤"
                    '5' -> "៥"
                    '6' -> "៦"
                    '7' -> "៧"
                    '8' -> "៨"
                    '9' -> "៩"
                    '0' -> "០"
                    else -> "$it"
                }
        }
        return newStr
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        content = {
            Box(modifier = Modifier.fillMaxWidth().fillMaxHeight(.5f),
                content = {
                    Image(
                        modifier = Modifier.align(Alignment.Center),
                        painter = getPainterResource("ic_launcher_192.png"),
                        contentDescription = null
                    )
                })
            AppText(
                modifier = Modifier.fillMaxWidth(.5f).align(Alignment.CenterHorizontally),
                text = when {
                    state.progress <= 0f -> "រៀបចំទាញយកទិន្នន័យលើកដំបូង... សូមមេត្តារង់ចាំ!"
                    state.progress >= 1f -> "វចនានុក្រមខ្មែរ"
                    else -> "កំពុងទាញយកទិន្នន័យលើកដំបូង... សូមមេត្តារង់ចាំ!"
                },
                fontSize = if (state.progress >= 1f) 22.sp else 18.sp,
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(32.dp))
            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth(.5f)
                    .align(Alignment.CenterHorizontally),
                progress = state.progress
            )
            if (state.progress < 1f) {
                Spacer(Modifier.height(8.dp))
                AppText(
                    modifier = Modifier.fillMaxWidth(.5f).align(Alignment.CenterHorizontally),
                    text = numToKhNum(ceil(state.progress * 100).toInt().toString()) + "%",
                    fontSize = 14.sp,
                    textAlign = TextAlign.End
                )
            }
        })

}