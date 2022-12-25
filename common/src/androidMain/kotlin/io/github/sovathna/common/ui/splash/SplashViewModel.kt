package io.github.sovathna.common.ui.splash

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.sovathna.common.BaseViewModel
import io.github.sovathna.common.data.interactor.DownloadAndUnzipWordsDatabaseInteractor
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val interactor: DownloadAndUnzipWordsDatabaseInteractor
) : BaseViewModel<SplashState>(SplashState()), BaseSplashViewModel {

    override val statesFlow: StateFlow<SplashState> = states

    override suspend fun init() {
        interactor.downloadAndUnzip()
            .distinctUntilChanged()
            .collectLatest {
                setState(current.newState(it))
            }
    }
}