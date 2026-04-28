package com.crouch.projectmtg.shared.core.dataStore

import com.crouch.projectmtg.shared.core.model.Theme
import kotlinx.serialization.Serializable

@Serializable
data class AppSettings(
    val theme: Theme = Theme.PLAINS,
    val importedDeck: List<String> = emptyList()
)
