package com.ridelink.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ridelink.app.Rider

@Composable
fun RidersScreen(
    modifier: Modifier = Modifier,
    riders: List<Rider>
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(Icons.Default.Group, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        Text("Your riders", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
        if (riders.isEmpty()) {
            Text("No riders paired yet.", style = MaterialTheme.typography.titleMedium)
            Text(
                "When device discovery is added, nearby riders will appear here.",
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Button(onClick = {}, enabled = false) {
                Text("Device discovery coming next")
            }
        } else {
            riders.forEach { rider ->
                Text(rider.name, style = MaterialTheme.typography.titleMedium)
                Text(rider.deviceName, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
