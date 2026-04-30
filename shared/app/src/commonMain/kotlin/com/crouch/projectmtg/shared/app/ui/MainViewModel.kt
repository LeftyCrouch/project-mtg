package com.crouch.projectmtg.shared.app.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crouch.projectmtg.shared.core.data.SettingsRepository
import com.crouch.projectmtg.shared.core.model.Theme
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import org.koin.core.annotation.KoinViewModel

@KoinViewModel
class MainViewModel(
    settingsRepository: SettingsRepository
) : ViewModel() {
    val theme = settingsRepository.theme.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = Theme.PLAINS
    )
}
