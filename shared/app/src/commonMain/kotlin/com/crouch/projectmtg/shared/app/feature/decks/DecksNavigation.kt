package com.crouch.projectmtg.shared.app.feature.decks

import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface DecksFeature : NavKey

@Serializable data object DecksRoute : DecksFeature

fun EntryProviderScope<NavKey>.decksFeatureEntryBuilder() {
    entry<DecksRoute> {
        Decks()
    }
}
