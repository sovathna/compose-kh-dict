package io.github.sovathna.common.data.interactor

import io.github.sovathna.common.Const
import io.github.sovathna.common.domain.Repository
import io.github.sovathna.domain.FileDownloadService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.util.zip.ZipInputStream

class DownloadAndUnzipWordsDatabaseInteractor(
    private val wordsDbFile: File,
    private val repository: Repository,
    private val downloadService: FileDownloadService
) {

    sealed interface Result {
        data class Downloading(val fraction: Float) : Result
        data class Error(val throwable: Throwable) : Result
        object Done : Result
    }

    fun downloadAndUnzip() = flow {
        emit(Result.Downloading(0f))
        delay(250)
        var dbOutputStream: FileOutputStream? = null
        var downloadInputStream: InputStream? = null
        var zipInputStream: ZipInputStream? = null
        try {
            if (repository.shouldDownloadData(Const.config.dataVersion) || !wordsDbFile.exists()) {
                if (wordsDbFile.exists()) wordsDbFile.delete()
                dbOutputStream = FileOutputStream(wordsDbFile)

                downloadInputStream =
                    downloadService.downloadDatabase(Const.DB_DOWNLOAD_URL).byteStream()
                zipInputStream = ZipInputStream(downloadInputStream)
                val entry = zipInputStream.nextEntry!!
                val reader = ByteArray(8 * 1024)
                var totalRead = 0L
                var last = System.currentTimeMillis()
                val size = entry.size.toFloat()
                while (true) {
                    currentCoroutineContext().ensureActive()
                    val read = zipInputStream.read(reader)
                    if (read == -1) break
                    dbOutputStream.write(reader, 0, read)
                    totalRead += read
                    val current = System.currentTimeMillis()
                    if (last + 500 <= current) {
                        val progress = totalRead / size
                        last = current
                        emit(Result.Downloading(progress))
                    }
                }
                repository.setDataVersion(1)
            }
            emit(Result.Downloading(1f))
            delay(250)
            emit(Result.Done)
        } catch (e: Exception) {
            e.printStackTrace()
            wordsDbFile.delete()
            emit(Result.Error(e))
        } finally {
            zipInputStream?.closeEntry()
            zipInputStream?.close()
            downloadInputStream?.close()
            dbOutputStream?.close()
        }
    }
        .flowOn(Dispatchers.IO)

}