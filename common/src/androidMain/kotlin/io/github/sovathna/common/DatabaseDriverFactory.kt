package io.github.sovathna.common

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import io.github.sovathna.domain.localdb.LocalDatabase
import io.github.sovathna.domain.wordsdb.WordsDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createWordsDriver(): SqlDriver {
        return AndroidSqliteDriver(WordsDatabase.Schema, context, "data.sqlite")
    }
    actual fun createLocalDriver(): SqlDriver {
        return AndroidSqliteDriver(LocalDatabase.Schema, context, "local_data.sqlite")
    }
}