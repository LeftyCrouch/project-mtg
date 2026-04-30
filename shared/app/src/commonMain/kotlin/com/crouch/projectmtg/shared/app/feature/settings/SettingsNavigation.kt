package com.crouch.projectmtg.shared.app.feature.settings

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable sealed interface SettingsFeature : NavKey

@Serializable data object SettingsRoute : SettingsFeature

fun EntryProviderScope<NavKey>.settingsFeatureEntryBuilder() {
    entry<SettingsRoute> {
        SettingsScreen()
    }
}
