buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.32")
        classpath("com.android.tools.build:gradle:4.2.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.33-beta")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.4.21")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}
