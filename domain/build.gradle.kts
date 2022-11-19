import dependencies.*

plugins {
    plugins.`android-base-library-core`
}
dependencies {
    addAndroidxCoreDependencies()
    addCoroutinesAndroidDependencies()
    addEntityModule(configurationName = "api")
    //addRoomDependencies()
    addNetworkDependencies()
}

android {
    namespace = "com.jetpack.domain"
}