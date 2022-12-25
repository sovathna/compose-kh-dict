package io.github.sovathna.common

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

interface AbstractAppViewModel {

    val state: MutableStateFlow<String>

    fun getName()

}