package com.crouch.projectmtg.shared.core.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.core.okio.OkioStorage
import kotlinx.cinterop.ExperimentalForeignApi
import okio.FileSystem
import okio.Path.Companion.toPath
import org.koin.core.annotation.Singleton
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@Singleton
class AppSettingsIOSDataStore : AppSettingsPlatformDataStore {
    override fun provideDataStore(): DataStore<AppSettings> {
        val filePath = "${fileDirectory()}/app-settings.json"
        return DataStoreFactory.create(
            storage =
                OkioStorage(
                    fileSystem = FileSystem.SYSTEM,
                    serializer = AppSettingsSerializer,
                    producePath = {
                        filePath.toPath()
                    }
                ),
            corruptionHandler = ReplaceFileCorruptionHandler { AppSettings() }
        )
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String {
        val documentDirectory: NSURL? =
            NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null
            )
        return requireNotNull(documentDirectory).path!!
    }
}
