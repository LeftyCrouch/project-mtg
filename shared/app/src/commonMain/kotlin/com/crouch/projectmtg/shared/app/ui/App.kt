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
import com.crouch.projectmtg.shared.app.feature.settings.SettingsScreen
import com.crouch.projectmtg.shared.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import projectmtg.shared.app.generated.resources.Res
import projectmtg.shared.app.generated.resources.deck
import projectmtg.shared.app.generated.resources.discover
import projectmtg.shared.app.generated.resources.tap

@Composable
fun App() {
    AppTheme {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = true,
                        onClick = {},
                        label = {
                            Text(
                                text = "Decks"
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
                        selected = false,
                        onClick = {},
                        label = {
                            Text(
                                text = "Discover"
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
                        selected = false,
                        onClick = {},
                        label = {
                            Text(
                                text = "Settings"
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
                                    text = ":create new deck"
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
                                    text = ":Import from Moxfield"
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
        ) {
            SettingsScreen()
        }
    }
}

@Composable
@Preview
private fun PreviewApp() {
    App()
}
