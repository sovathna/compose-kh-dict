package io.github.sovathna.android

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.sovathna.common.AbstractAppViewModel
import io.github.sovathna.common.getPlatformName
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor() : ViewModel(), AbstractAppViewModel {
    override val state: MutableStateFlow<String> = MutableStateFlow("Hello world")

    override fun getName() {
        state.value = "Hello, ${getPlatformName()}"
    }
}