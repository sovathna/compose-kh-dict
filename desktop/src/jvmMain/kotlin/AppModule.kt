package io.github.sovathna

import com.google.gson.GsonBuilder
import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext


val appModule = module {

    single {
        GsonBuilder()
            .serializeNulls()
            .setLenient()
            .setPrettyPrinting()
            .create()
    }

    single<CoroutineContext>(qualifier = (named("io_dispatcher"))){
        Dispatchers.IO
    }
}