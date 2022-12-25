package io.github.sovathna.common

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.sqlite.driver.JdbcSqliteDriver
import org.koin.core.component.KoinComponent

actual class DatabaseDriverFactory :KoinComponent{
    actual fun createWordsDriver(): SqlDriver {
        return JdbcSqliteDriver("jdbc:sqlite:")
    }

    actual fun createLocalDriver(): SqlDriver {
        return JdbcSqliteDriver("jdbc:sqlite:")
    }
}