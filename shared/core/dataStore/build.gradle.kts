plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidKotlinMultiplatformLibrary)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.koin)
}

kotlin {
    android {
        namespace = "com.crouch.projectmtg.shared.core.dataStore"
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
            baseName = "shared:core:dataStore"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            // datastore
            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences)
            implementation(libs.com.squareup.okio)
            // koin
            implementation(libs.koin.core)
            implementation(libs.koin.annotations)
            // serialization
            implementation(libs.kotlinx.serialization.json)
            // coroutines
            implementation(libs.kotlin.coroutines.core)
            // local modules
            implementation(projects.shared.core.logger)
            implementation(projects.shared.core.model)
        }
    }
}
