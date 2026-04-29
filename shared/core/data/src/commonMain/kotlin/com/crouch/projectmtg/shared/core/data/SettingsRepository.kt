package com.crouch.projectmtg.shared.core.data

import com.crouch.projectmtg.shared.core.dataStore.AppSettingsDataStore
import com.crouch.projectmtg.shared.core.model.Theme
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Singleton

@Singleton
class SettingsRepository(
    private val appSettingsDataStore: AppSettingsDataStore
) {
    val theme: Flow<Theme> = appSettingsDataStore.theme

    suspend fun changeTheme(theme: Theme) {
        appSettingsDataStore.setTheme(theme)
    }
}
