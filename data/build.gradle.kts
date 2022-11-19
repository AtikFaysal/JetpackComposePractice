import dependencies.*

plugins {
    plugins.`android-base-library-core`
}

dependencies {
    addNetworkDependencies(configurationName = "api")
    addDiModule(configurationName = "api")
    addApiResponseModule(configurationName = "api")
    //addCacheModule(configurationName = "api")
    addDomainModule()
    addCoroutinesAndroidDependencies()
    addRxjava3Dependencies()
}

android {
    namespace = "com.jetpack.data"
}