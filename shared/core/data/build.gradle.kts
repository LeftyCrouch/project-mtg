plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.koin)
}

kotlin {
    android {
        namespace = "com.crouch.projectmtg.shared.core.data"
        compileSdk {
            version = release(libs.versions.android.compileSdk.get().toInt())
        }
        minSdk = libs.versions.android.minSdk.get().toInt()
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared:core:data"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // coroutines
            implementation(libs.kotlin.coroutines.core)
            // koin
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
            // local modules
            implementation(projects.shared.core.dataStore)
            implementation(projects.shared.core.model)
        }
    }
}
