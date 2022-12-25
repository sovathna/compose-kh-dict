package io.github.sovathna.common.data

import io.github.sovathna.domain.FileDownloadService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.time.Duration

class FileDownloadServiceFactory {

    fun createService(): FileDownloadService =
        createRetrofit().create(FileDownloadService::class.java)

    private fun createClient(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(Duration.ZERO)
            .addInterceptor(
                HttpLoggingInterceptor { println(it) }
                    .apply { level = HttpLoggingInterceptor.Level.HEADERS }
            )
            .build()

    private fun createRetrofit(): Retrofit = Retrofit.Builder()
        .client(createClient())
        .baseUrl("https://example.com/")
        .build()
}