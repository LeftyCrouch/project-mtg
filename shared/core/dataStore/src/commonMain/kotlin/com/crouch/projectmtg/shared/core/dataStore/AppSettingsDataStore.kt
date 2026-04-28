package com.crouch.projectmtg.shared.core.dataStore

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import com.crouch.projectmtg.shared.core.logger.LogIt
import com.crouch.projectmtg.shared.core.model.Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Singleton

@Singleton
class AppSettingsDataStore(
    platformDataStore: AppSettingsPlatformDataStore
) {
    val db: DataStore<AppSettings> = platformDataStore.provideDataStore()

    val theme: Flow<Theme> = db.data
        .catch { exception ->
            if (exception is IOException) {
                LogIt.error(
                    throwable = exception
                ) { "Failed to read datastore theme as a flow" }
                emit(AppSettings())
            }
        }.map { appSettings ->
            appSettings.theme
        }

    val importedDeck: Flow<List<String>> = db.data
        .catch { exception ->
            if (exception is IOException) {
                LogIt.error(
                    throwable = exception
                ) { "Failed to read datastore imported deck as a flow" }
                emit(AppSettings())
            }
        }.map { appSettings ->
            appSettings.importedDeck
        }

    suspend fun setTheme(theme: Theme) {
        try {
            db.updateData { currentSettings ->
                currentSettings.copy(
                    theme = theme
                )
            }
        } catch (e: IOException) {
            LogIt.error(
                throwable = e
            ) { "Failed to write data to disk for theme in datastore" }
        } catch (e: Exception) {
            LogIt.error(
                throwable = e
            ) { "Transform function for setting theme datastore failed" }
        }
    }

    suspend fun setImportedDeck(importedDeck: List<String>) {
        try {
            db.updateData { currentSettings ->
                currentSettings.copy(
                    importedDeck = importedDeck
                )
            }
        } catch (e: IOException) {
            LogIt.error(
                throwable = e
            ) { "Failed to write data to disk for imported deck in datastore" }
        } catch (e: Exception) {
            LogIt.error(
                throwable = e
            ) { "Transform function for setting imported deck datastore failed" }
        }
    }

    suspend fun removeImportedDeck() {
        try {
            db.updateData { currentSettings ->
                currentSettings.copy(
                    importedDeck = emptyList()
                )
            }
        } catch (e: IOException) {
            LogIt.error(
                throwable = e
            ) { "Failed to write data to disk for removing imported deck in datastore" }
        } catch (e: Exception) {
            LogIt.error(
                throwable = e
            ) { "Transform function for removing imported deck datastore failed" }
        }
    }
}
