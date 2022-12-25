package io.github.sovathna.common

import kotlinx.coroutines.flow.MutableStateFlow

class AppViewModel : AbstractAppViewModel {

    override val state: MutableStateFlow<String> = MutableStateFlow("Hello, world!")
    override fun getName() {
        state.value = "Hello, ${getPlatformName()}"
    }
}