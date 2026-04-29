pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "ProjectMTG"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// android app
include(":androidApp")
// shared app
include(":shared:app")
// shared libraries
include(":shared:core:model")
include(":shared:core:logger")
include(":shared:core:ui")
include(":shared:core:dataStore")
include(":shared:core:data")
