package io.github.sovathna.common.domain

import io.github.sovathna.data.wordsdb.dao.SelectDefinition

interface Repository {
    suspend fun getDefinition(wordId: Long): SelectDefinition

    suspend fun addHistory(wordId: Long, word: String)

    suspend fun isBookmark(wordId: Long): Boolean

    suspend fun addOrDeleteBookmark(isBookmark: Boolean, wordId: Long, word: String): Boolean

    suspend fun setFontSize(size: Float)

    suspend fun getFontSize(): Float

    suspend fun getDataVersion(): Int

    suspend fun setDataVersion(version: Int)

    suspend fun shouldDownloadData(newVersion: Int): Boolean
}