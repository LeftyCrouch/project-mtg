package com.crouch.projectmtg.shared.app.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.crouch.projectmtg.shared.app.feature.decks.decksFeatureEntryBuilder
import com.crouch.projectmtg.shared.app.feature.discover.discoverFeatureEntryBuilder
import com.crouch.projectmtg.shared.app.feature.settings.settingsFeatureEntryBuilder

@Composable
fun AppNavHost(
    navBackStack: NavBackStack<NavKey>,
    paddingValues: PaddingValues
) {
    NavDisplay(
        backStack = navBackStack,
        modifier = Modifier.padding(paddingValues),
        entryProvider = entryProvider {
            decksFeatureEntryBuilder()
            discoverFeatureEntryBuilder()
            settingsFeatureEntryBuilder()
        },
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        )
    )
}
