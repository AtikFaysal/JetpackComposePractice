import dependencies.*
import com.android.build.gradle.internal.api.BaseVariantOutputImpl
import java.text.SimpleDateFormat
import java.util.Calendar

plugins {
    id ("com.android.application")
    kotlin("android")
    kotlin("kapt")
    //id ("com.google.gms.google-services")
    //id ("com.google.firebase.crashlytics")
    //id("androidx.navigation.safeargs")
    id ("dagger.hilt.android.plugin")
}

android {
    compileSdk  = AppConfig.compileSdkVersion
    defaultConfig {
        applicationId  = AppConfig.applicationId
        minSdk  = AppConfig.minSdkVersion
        targetSdk  = AppConfig.targetSdkVersion
        versionCode  = AppConfig.versionCode
        versionName  = AppConfig.versionName
        testInstrumentationRunner = AppConfig.testRunner
    }
    buildTypes {
        debug {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
    namespace = "com.jetpack.compose"
}

dependencies {
    addFeatureModules()
    addDataModule()
    addDomainModule()
    addCommonModule()
    //addAssetsModule()
   // addNavigation()

    addAndroidxCoreDependencies()
    addAndroidxLifeCycleDependencies()
    addHiltDependencies()
    addRxjava3Dependencies()
    addRoomDependencies()
    addPlayCoreDependencies()
    addFirebaseDependencies()
    addLeakcanaryDependencies()
    addAndroidTestsDependencies()
}

kapt {
    correctErrorTypes = true
}