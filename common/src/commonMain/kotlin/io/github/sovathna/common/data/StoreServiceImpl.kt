package io.github.sovathna.common.data

import io.github.sovathna.common.domain.StoreService

expect class StoreServiceImpl : StoreService {
    override suspend fun getDataVersion(): Int
    override suspend fun setDataVersion(version: Int)
    override suspend fun setDefinitionFontSize(size: Float)
    override suspend fun getDefinitionFontSize(): Float
}