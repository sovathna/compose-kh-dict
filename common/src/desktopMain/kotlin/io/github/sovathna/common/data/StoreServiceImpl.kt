package io.github.sovathna.common.data

import com.google.gson.Gson
import io.github.sovathna.common.domain.StoreService
import java.io.File
import kotlin.coroutines.CoroutineContext

actual class StoreServiceImpl(
    private val gson: Gson,
    private val storeFile: File,
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