package io.github.sovathna.common.data

import android.content.SharedPreferences
import io.github.sovathna.common.domain.StoreService
import kotlin.coroutines.CoroutineContext


actual class StoreServiceImpl(
    private val pref: SharedPreferences,
    private val ioDispatcher: CoroutineContext
) : StoreService {
    actual override suspend fun getDataVersion(): Int {
        TODO("Not yet implemented")
    }

    actual override suspend fun setDataVersion(version: Int) {
        TODO("Not yet implemented")
    }

    actual override suspend fun setDefinitionFontSize(size: Float) {
        TODO("Not yet implemented")
    }

    actual override suspend fun getDefinitionFontSize(): Float {
        TODO("Not yet implemented")
    }
}