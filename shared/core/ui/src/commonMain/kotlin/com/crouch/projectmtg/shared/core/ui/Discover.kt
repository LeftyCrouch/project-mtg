package com.crouch.projectmtg.shared.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.crouch.projectmtg.shared.core.ui.theme.AppTheme

@Composable
fun Discover() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Discover",
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
@Preview
private fun Preview() {
    AppTheme {
        Discover()
    }
}
