package com.crouch.projectmtg.shared.app.feature.discover

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable sealed interface DiscoverFeature : NavKey

@Serializable data object DiscoverRoute : DiscoverFeature

fun EntryProviderScope<NavKey>.discoverFeatureEntryBuilder() {
    entry<DiscoverRoute> {
        DiscoverScreen()
    }
}
