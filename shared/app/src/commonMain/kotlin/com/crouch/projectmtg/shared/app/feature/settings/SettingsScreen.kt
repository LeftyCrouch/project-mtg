package com.crouch.projectmtg.shared.app.feature.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.crouch.projectmtg.shared.core.ui.Settings
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SettingsScreen() {
    val viewModel: SettingsViewModel = koinViewModel()
    val theme by viewModel.theme.collectAsStateWithLifecycle()

    Settings(
        theme = theme,
        onChangeTheme = viewModel::changeTheme
    )
}
