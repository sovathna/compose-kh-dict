package io.github.sovathna.common.ui.splash

import io.github.sovathna.common.DesktopViewModel
import io.github.sovathna.common.data.interactor.DownloadAndUnzipWordsDatabaseInteractor
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SplashViewModel : DesktopViewModel<SplashState>(SplashState()),
    BaseSplashViewModel,
    KoinComponent {

    override val statesFlow: StateFlow<SplashState> = states
    private val interactor: DownloadAndUnzipWordsDatabaseInteractor by inject()

    override suspend fun init() {
        interactor.downloadAndUnzip()
            .distinctUntilChanged()
            .collectLatest {
                setState(current.newState(it))
            }
    }

}