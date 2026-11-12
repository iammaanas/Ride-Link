package com.ridelink.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

private val MutedText = Color(0xFF858B98)

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    isConnected: Boolean,
    onFindRider: () -> Unit,
    onOpenIntercom: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize().padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Spacer(Modifier.height(2.dp))
        Text("Good evening, Rider", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.SemiBold)
        Text("Your next ride starts with a connection.", color = MutedText)

        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Column(
                Modifier.fillMaxWidth().padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Text("YOUR CONNECTION", style = MaterialTheme.typography.labelMedium, color = MutedText)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        if (isConnected) "Connected" else "Not connected",
                        modifier = Modifier.weight(1f),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                    BoxDot(isConnected)
                }
                Text(
                    if (isConnected) "Your intercom session is ready." else "Pair with another rider to start an offline intercom session.",
                    color = MutedText
                )
                Button(onClick = onFindRider, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Default.Group, contentDescription = null)
                    Text("  Find a rider")
                }
                Text("Offline communication · Internet not required", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelSmall)
            }
        }

        Text("Quick actions", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
        Card(
            onClick = onFindRider,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Group, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                Column(Modifier.weight(1f).padding(start = 14.dp)) {
                    Text("Riders", fontWeight = FontWeight.SemiBold)
                    Text("View and pair with riders", color = MutedText, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
        Card(
            onClick = onOpenIntercom,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
        ) {
            Row(Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.Headset, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                Column(Modifier.weight(1f).padding(start = 14.dp)) {
                    Text("Intercom", fontWeight = FontWeight.SemiBold)
                    Text("Open communication controls", color = MutedText, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
}

@Composable
private fun BoxDot(active: Boolean) {
    Spacer(
        Modifier.size(11.dp).clip(CircleShape)
            .background(if (active) Color(0xFF2E9B69) else MutedText)
    )
}
