package io.github.sovathna.common

import kotlinx.coroutines.flow.MutableStateFlow

abstract class DesktopViewModel<S>(initState: S) {
    protected val states = MutableStateFlow(initState)

    protected fun setState(state: S) {
        states.value = state
    }
}