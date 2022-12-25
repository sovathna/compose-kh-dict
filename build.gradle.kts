group "io.github.sovathna"
version "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

plugins {
    kotlin("multiplatform") apply false
    kotlin("android") apply false
    id("com.android.application") apply false
    id("com.android.library") apply false
    id("org.jetbrains.compose") apply false
    id("com.google.dagger.hilt.android") version "2.44.2" apply false
    id("com.squareup.sqldelight") version "1.5.4" apply false
}