package io.github.sovathna.common.data

import io.github.sovathna.common.domain.Repository
import io.github.sovathna.data.wordsdb.dao.SelectDefinition

class RepositoryImpl:Repository {
    override suspend fun getDefinition(wordId: Long): SelectDefinition {
        TODO("Not yet implemented")
    }

    override suspend fun addHistory(wordId: Long, word: String) {
        TODO("Not yet implemented")
    }

    override suspend fun isBookmark(wordId: Long): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun addOrDeleteBookmark(
        isBookmark: Boolean,
        wordId: Long,
        word: String
    ): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun setFontSize(size: Float) {
        TODO("Not yet implemented")
    }

    override suspend fun getFontSize(): Float {
        TODO("Not yet implemented")
    }

    override suspend fun getDataVersion(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun setDataVersion(version: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun shouldDownloadData(newVersion: Int): Boolean {
        TODO("Not yet implemented")
    }
}