

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    id("com.android.library")
    id("com.squareup.sqldelight")
}

group = "io.github.sovathna"
version = "1.0-SNAPSHOT"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api("com.squareup.okhttp3:okhttp:4.10.0")
                api("com.squareup.okhttp3:logging-interceptor:4.10.0")
                api("com.squareup.retrofit2:retrofit:2.9.0")
                api("com.google.code.gson:gson:2.10")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.appcompat:appcompat:1.5.1")
                api("androidx.core:core-ktx:1.9.0")
                api("com.google.dagger:hilt-android:2.44.2")
                val lifecycle_version = "2.5.1"
                api("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
                api("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
                api("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
                api("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")
                implementation ("com.squareup.sqldelight:android-driver:1.5.4")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:4.13.2")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                api("io.insert-koin:koin-core:3.3.0")
                implementation("com.squareup.sqldelight:sqlite-driver:1.5.4")
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdk = 33
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 33
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

sqldelight {
    database("WordsDatabase") {
        packageName = "io.github.sovathna.domain.wordsdb"
        sourceFolders = listOf("wordsdb")
        dialect = "sqlite:3.25"
        //verifyMigrations = true
    }

    database("LocalDatabase") {
        packageName = "io.github.sovathna.domain.localdb"

        // An array of folders where the plugin will read your '.sq' and '.sqm'
        // files. The folders are relative to the existing source set so if you
        // specify ["db"], the plugin will look into 'src/main/db' or 'src/commonMain/db' for KMM.
        // Defaults to ["sqldelight"]
        sourceFolders = listOf("localdb")
        dialect = "sqlite:3.25"
        //verifyMigrations = true
    }
}