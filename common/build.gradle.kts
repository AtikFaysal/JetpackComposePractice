import dependencies.*

plugins {
    plugins.`android-base-library`
}
dependencies {
    //addAndroidxNavigationDependencies()
    addAndroidxCoreDependencies()
    addAndroidxLifeCycleDependencies()
    addRxjava3Dependencies()
    //addPlayCoreDependencies()
    addEntityModule()
    //addSharedPrefModule()
    addPicassoDependencies()
    addCircleImageviewDependencies()
    //addAssetsModule()
    //addGoogleMapDependencies()
    addAlerterDependencies()
    addAndroidResponsiveSizeDependenciesDependencies()
}

android {
    namespace = "com.jetpack.common"
}
