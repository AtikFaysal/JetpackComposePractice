pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
        google()
        maven ("https://jitpack.io")
        maven ("https://oss.jfrog.org/libs-snapshot")
    }
}

rootProject.name = "StudentPayment"

include (":app")
include(":common")
include(":data")
include(":di")
include(":domain")
include(":model:api-entity")
include(":model:api-response")

include(":feature:repo-list")
include(":feature:repo-details")
