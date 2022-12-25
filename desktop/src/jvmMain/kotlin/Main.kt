// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.github.sovathna.common.App
import io.github.sovathna.common.AppViewModel
import io.github.sovathna.common.ui.splash.SplashScreen
import io.github.sovathna.common.ui.splash.SplashViewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level


fun main(){
    startKoin {
        printLogger(Level.DEBUG)
    }
    application {
        Window(onCloseRequest = ::exitApplication) {
            SplashScreen(viewModel = remember { SplashViewModel() }){

            }
        }
    }
}
