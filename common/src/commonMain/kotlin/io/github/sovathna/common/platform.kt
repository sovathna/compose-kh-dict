package io.github.sovathna.common

import androidx.compose.runtime.Composable

expect fun getPlatformName(): String

@Composable
expect fun Test()