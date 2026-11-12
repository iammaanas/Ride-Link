package com.ridelink.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun IntercomScreen(
    modifier: Modifier = Modifier,
    isConnected: Boolean
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.Headset, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Text("Intercom", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
        Text(
            if (isConnected) "Rider connected. Audio transport is not configured yet."
            else "Connect to another rider before starting a conversation.",
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Button(onClick = {}, enabled = false) {
            Text("Hold to talk")
        }
        Text(
            "Push-to-talk will be enabled after offline device connection and audio streaming are implemented.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
