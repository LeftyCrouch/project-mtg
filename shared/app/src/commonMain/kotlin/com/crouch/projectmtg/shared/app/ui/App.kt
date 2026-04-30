package com.crouch.projectmtg.shared.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.rememberNavBackStack
import com.crouch.projectmtg.shared.app.feature.decks.DecksRoute
import com.crouch.projectmtg.shared.app.feature.discover.DiscoverRoute
import com.crouch.projectmtg.shared.app.feature.settings.SettingsRoute
import com.crouch.projectmtg.shared.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import projectmtg.shared.app.generated.resources.Res
import projectmtg.shared.app.generated.resources.create_new_deck
import projectmtg.shared.app.generated.resources.deck
import projectmtg.shared.app.generated.resources.decks
import projectmtg.shared.app.generated.resources.discover
import projectmtg.shared.app.generated.resources.import_from_moxfield
import projectmtg.shared.app.generated.resources.settings
import projectmtg.shared.app.generated.resources.tap

@Composable
fun App() {
    val backStack = rememberNavBackStack(config, DecksRoute)
    val viewModel: MainViewModel = koinViewModel()
    val theme by viewModel.theme.collectAsStateWithLifecycle()

    AppTheme(
        theme = theme
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = backStack.lastOrNull() == DecksRoute,
                        onClick = {
                            backStack.removeAll { it == DecksRoute }
                            backStack.add(DecksRoute) },
                        label = {
                            Text(
                                text = stringResource(Res.string.decks)
                            )
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(Res.drawable.deck),
                                contentDescription = null
                            )
                        }
                    )
                    NavigationBarItem(
                        selected = backStack.lastOrNull() == DiscoverRoute,
                        onClick = {
                            backStack.removeAll { it == DiscoverRoute }
                            backStack.add(DiscoverRoute) },
                        label = {
                            Text(
                                text = stringResource(Res.string.discover)
                            )
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(Res.drawable.discover),
                                contentDescription = null
                            )
                        }
                    )
                    NavigationBarItem(
                        selected = backStack.lastOrNull() == SettingsRoute,
                        onClick = {
                            backStack.removeAll { it == SettingsRoute }
                            backStack.add(SettingsRoute) },
                        label = {
                            Text(
                                text = stringResource(Res.string.settings)
                            )
                        },
                        icon = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = Icons.Default.Settings,
                                contentDescription = null
                            )
                        }
                    )
                }
            },
            floatingActionButton = {
                if (backStack.lastOrNull() == DecksRoute) {
                    var showContent by remember { mutableStateOf(false) }
                    if (showContent) {
                        Column(
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            modifier = Modifier.padding(4.dp)
                        ) {
                            ExtendedFloatingActionButton(
                                onClick = { showContent = false }
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        modifier = Modifier.size(24.dp),
                                        painter = painterResource(Res.drawable.tap),
                                        tint = null,
                                        contentDescription = null
                                    )
                                    Text(
                                        modifier = Modifier.padding(start = 2.dp),
                                        text = stringResource(Res.string.create_new_deck)
                                    )
                                }
                            }
                            ExtendedFloatingActionButton(
                                onClick = { showContent = false }
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    Icon(
                                        modifier = Modifier.size(24.dp),
                                        painter = painterResource(Res.drawable.tap),
                                        tint = null,
                                        contentDescription = null
                                    )
                                    Text(
                                        modifier = Modifier.padding(start = 2.dp),
                                        text = stringResource(Res.string.import_from_moxfield)
                                    )
                                }
                            }
                        }
                    } else {
                        FloatingActionButton(
                            onClick = {
                                showContent = true
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        ) { paddingValues ->
            AppNavHost(
                backStack,
                paddingValues
            )
        }
    }
}

@Composable
@Preview
private fun PreviewApp() {
    App()
}