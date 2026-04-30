package com.crouch.projectmtg.shared.app.ui

import androidx.navigation3.runtime.NavKey
import androidx.savedstate.serialization.SavedStateConfiguration
import com.crouch.projectmtg.shared.app.feature.decks.DecksFeature
import com.crouch.projectmtg.shared.app.feature.discover.DiscoverFeature
import com.crouch.projectmtg.shared.app.feature.settings.SettingsFeature
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@OptIn(ExperimentalSerializationApi::class)
internal val config = SavedStateConfiguration {
    serializersModule = SerializersModule {
        polymorphic(NavKey::class) {
            subclassesOfSealed<DecksFeature>()
            subclassesOfSealed<DiscoverFeature>()
            subclassesOfSealed<SettingsFeature>()
        }
    }
}
