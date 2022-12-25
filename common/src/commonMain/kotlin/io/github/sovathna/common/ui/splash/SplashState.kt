package io.github.sovathna.common.ui.splash

import io.github.sovathna.common.data.interactor.DownloadAndUnzipWordsDatabaseInteractor

data class SplashState(
    val progress: Float = 0f,
    val isDone: Boolean = false,
    val throwable: Throwable? = null
){
    fun newState(result: DownloadAndUnzipWordsDatabaseInteractor.Result) =
        when (result) {
            DownloadAndUnzipWordsDatabaseInteractor.Result.Done -> {
                copy(progress = 1f, isDone = true)
            }
            is DownloadAndUnzipWordsDatabaseInteractor.Result.Downloading -> {
                copy(progress = result.fraction)
            }
            is DownloadAndUnzipWordsDatabaseInteractor.Result.Error -> {
                copy(throwable = result.throwable)
            }
        }


}
