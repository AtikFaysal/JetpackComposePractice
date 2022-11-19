buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        google()
        maven ("https://jitpack.io")
        maven ("https://oss.jfrog.org/libs-snapshot")
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.3.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
       // classpath ("com.google.gms:google-services:${AppConfig.googleServicesVersion}")
        //classpath ("com.google.firebase:firebase-crashlytics-gradle:${AppConfig.firebaseCrashAnalyticGradleVersion}")
        //classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${AppConfig.safe_args_version}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${AppConfig.hilt_android_version}")
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        jcenter()
        google()
        maven ("https://jitpack.io")
        maven ("https://oss.jfrog.org/libs-snapshot")
    }
}

tasks.create<Delete>("clean") {
    delete  = setOf(
        rootProject.buildDir
    )
}
