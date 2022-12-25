package io.github.sovathna.common.domain

interface StoreService {
    suspend fun getDataVersion(): Int

    suspend fun setDataVersion(version: Int)
    suspend fun setDefinitionFontSize(size: Float)

    suspend fun getDefinitionFontSize(): Float
}