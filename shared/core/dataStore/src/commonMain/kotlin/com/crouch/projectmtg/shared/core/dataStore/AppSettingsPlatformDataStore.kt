package com.crouch.projectmtg.shared.core.dataStore

import androidx.datastore.core.DataStore

interface AppSettingsPlatformDataStore {
    fun provideDataStore(): DataStore<AppSettings>
}
