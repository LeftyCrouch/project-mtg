package com.crouch.projectmtg.shared.core.dataStore

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.core.okio.OkioStorage
import okio.FileSystem
import okio.Path.Companion.toPath
import org.koin.core.annotation.Singleton

@Singleton
class AppSettingsAndroidDataStore(
    private val application: Application
) : AppSettingsPlatformDataStore {
    override fun provideDataStore(): DataStore<AppSettings> {
        val filePath = application.filesDir
            .resolve(
                "app-settings.json"
            ).absolutePath

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
}
