package io.github.sovathna.common

import kotlinx.coroutines.flow.StateFlow

interface BaseViewModel<S> {
    val statesFlow: StateFlow<S>
    val current get() = statesFlow.value!!
}