package com.crouch.projectmtg.shared.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.crouch.projectmtg.shared.core.model.Theme
import com.crouch.projectmtg.shared.core.ui.theme.forest.forestDarkScheme
import com.crouch.projectmtg.shared.core.ui.theme.forest.forestLightScheme
import com.crouch.projectmtg.shared.core.ui.theme.island.islandDarkScheme
import com.crouch.projectmtg.shared.core.ui.theme.island.islandLightScheme
import com.crouch.projectmtg.shared.core.ui.theme.mountain.mountainDarkScheme
import com.crouch.projectmtg.shared.core.ui.theme.mountain.mountainLightScheme
import com.crouch.projectmtg.shared.core.ui.theme.plains.plainsDarkScheme
import com.crouch.projectmtg.shared.core.ui.theme.plains.plainsLightScheme
import com.crouch.projectmtg.shared.core.ui.theme.swamp.swampDarkScheme
import com.crouch.projectmtg.shared.core.ui.theme.swamp.swampLightScheme

@Composable
fun AppTheme(
    theme: Theme = Theme.PLAINS,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable (() -> Unit)
) {
    val colorScheme = when (theme) {
        Theme.MOUNTAIN -> if (darkTheme) mountainDarkScheme else mountainLightScheme
        Theme.FOREST -> if (darkTheme) forestDarkScheme else forestLightScheme
        Theme.ISLAND -> if (darkTheme) islandDarkScheme else islandLightScheme
        Theme.SWAMP -> if (darkTheme) swampDarkScheme else swampLightScheme
        Theme.PLAINS -> if (darkTheme) plainsDarkScheme else plainsLightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = appTypography(),
        content = content
    )
}
