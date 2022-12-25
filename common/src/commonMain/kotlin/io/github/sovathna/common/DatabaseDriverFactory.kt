package io.github.sovathna.common

import com.squareup.sqldelight.db.SqlDriver
import io.github.sovathna.domain.localdb.LocalDatabase
import io.github.sovathna.domain.wordsdb.WordsDatabase

expect class DatabaseDriverFactory {
    fun createWordsDriver(): SqlDriver
    fun createLocalDriver(): SqlDriver
}

fun createWordsDatabase(factory: DatabaseDriverFactory): WordsDatabase {
    return WordsDatabase(factory.createWordsDriver())
}

fun createLocalDatabase(factory: DatabaseDriverFactory): LocalDatabase {
    return LocalDatabase(factory.createLocalDriver())
}