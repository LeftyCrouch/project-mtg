package com.crouch.projectmtg.shared.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crouch.projectmtg.shared.core.model.Theme
import com.crouch.projectmtg.shared.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import projectmtg.shared.core.ui.generated.resources.Res
import projectmtg.shared.core.ui.generated.resources.forest
import projectmtg.shared.core.ui.generated.resources.island
import projectmtg.shared.core.ui.generated.resources.mountain
import projectmtg.shared.core.ui.generated.resources.plains
import projectmtg.shared.core.ui.generated.resources.swamp
import projectmtg.shared.core.ui.generated.resources.theme

@Composable
fun Settings(
    theme: Theme,
    onChangeTheme: (Theme) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = stringResource(Res.string.theme),
                style = MaterialTheme.typography.headlineLarge
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Theme.entries.forEach {
                    val modifier = if (it == theme) {
                        Modifier.background(
                            color = MaterialTheme.colorScheme.onBackground,
                            shape = CircleShape
                        )
                    } else {
                        Modifier
                    }
                    IconButton(
                        modifier = modifier,
                        onClick = { onChangeTheme(it) }
                    ) {
                        val image = when (it) {
                            Theme.MOUNTAIN -> Res.drawable.mountain
                            Theme.FOREST -> Res.drawable.forest
                            Theme.ISLAND -> Res.drawable.island
                            Theme.SWAMP -> Res.drawable.swamp
                            Theme.PLAINS -> Res.drawable.plains
                        }
                        Icon(
                            painter = painterResource(image),
                            tint = null,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        Settings(
            theme = Theme.MOUNTAIN,
            onChangeTheme = { }
        )
    }
}
