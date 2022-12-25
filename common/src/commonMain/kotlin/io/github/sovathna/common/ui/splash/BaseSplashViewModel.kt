package io.github.sovathna.common.ui.splash

import io.github.sovathna.common.BaseViewModel

interface BaseSplashViewModel : BaseViewModel<SplashState> {
   suspend fun init()
}