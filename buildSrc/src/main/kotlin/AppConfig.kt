import core.Versions

object AppConfig {
    const val applicationId = "com.jetpack.compose"
    const val testRunner = "androidx.test.runner.AndroidJUnitRunner"
    const val minSdkVersion = 21
    const val compileSdkVersion = 33
    const val targetSdkVersion = 33
    const val versionCode  = 1
    const val versionName  = "1.0.0"

    const val buildGradle_version = Versions.buildGradle_version
    const val kotlin_version = Versions.kotlin_version
    const val firebaseCrashAnalyticGradleVersion = Versions.firebaseCrashAnalyticGradleVersion
    const val googleServicesVersion = Versions.googleServicesVersion
    const val hilt_android_version = Versions.hilt_android_version
    const val safe_args_version = Versions.nav_version
}