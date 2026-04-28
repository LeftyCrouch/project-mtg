package com.crouch.projectmtg.shared.app.feature.settings

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingsScreen() {
    val viewModel: SettingsViewModel = koinViewModel()

    Text(
        text = viewModel.settingsScreen,
        style = MaterialTheme.typography.displayLarge
    )
}
