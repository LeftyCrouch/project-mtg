package com.crouch.projectmtg.shared.app.feature.decks

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.crouch.projectmtg.shared.core.ui.theme.AppTheme

@Composable
fun Decks() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(2) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Title",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = "Commander's Name",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun Preview() {
    AppTheme(darkTheme = true) {
        Scaffold {
            Decks()
        }
    }
}
