plugins {
    id("org.jetbrains.compose")
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

group "io.github.sovathna"
version "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("androidx.activity:activity-compose:1.6.1")
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    val fragment_version = "1.5.5"
    implementation("androidx.fragment:fragment-ktx:$fragment_version")
    val activity_version = "1.6.1"
    implementation("androidx.activity:activity-ktx:$activity_version")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "io.github.sovathna.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0-SNAPSHOT"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

kapt {
    correctErrorTypes = true
}