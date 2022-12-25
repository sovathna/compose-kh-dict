package io.github.sovathna.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel<S>(initState: S) : ViewModel() {
    protected val states = MutableStateFlow(initState)

    protected fun setState(state: S) {
        states.value = state
    }
}