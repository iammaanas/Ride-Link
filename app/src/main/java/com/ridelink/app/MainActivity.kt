package com.ridelink.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.ridelink.app.ui.screens.HomeScreen
import com.ridelink.app.ui.screens.IntercomScreen
import com.ridelink.app.ui.screens.RidersScreen
import com.ridelink.app.ui.screens.SettingsScreen
import com.ridelink.app.ui.theme.RideLinkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var darkTheme by remember { mutableStateOf(true) }
            RideLinkTheme(darkTheme = darkTheme) {
                RideLinkApp(
                    darkTheme = darkTheme,
                    onThemeChanged = { darkTheme = it }
                )
            }
        }
    }
}

private enum class AppTab(val label: String) {
    Home("Home"),
    Riders("Riders"),
    Intercom("Intercom"),
    Settings("Settings")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RideLinkApp(
    darkTheme: Boolean,
    onThemeChanged: (Boolean) -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val session = remember { RideLinkSessionState() }
    val tabs = AppTab.entries

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("RideLink") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        bottomBar = {
            NavigationBar {
                tabs.forEachIndexed { index, tab ->
                    val icon = when (tab) {
                        AppTab.Home -> Icons.Default.Home
                        AppTab.Riders -> Icons.Default.Group
                        AppTab.Intercom -> Icons.AutoMirrored.Filled.Chat
                        AppTab.Settings -> Icons.Default.Settings
                    }
                    NavigationBarItem(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        icon = { Icon(icon, contentDescription = tab.label) },
                        label = { Text(tab.label) }
                    )
                }
            }
        }
    ) { padding ->
        when (tabs[selectedTab]) {
            AppTab.Home -> HomeScreen(
                modifier = Modifier.padding(padding),
                isConnected = session.isConnected,
                onFindRider = { selectedTab = AppTab.Riders.ordinal },
                onOpenIntercom = { selectedTab = AppTab.Intercom.ordinal }
            )
            AppTab.Riders -> RidersScreen(
                modifier = Modifier.padding(padding),
                riders = session.riders
            )
            AppTab.Intercom -> IntercomScreen(
                modifier = Modifier.padding(padding),
                isConnected = session.isConnected
            )
            AppTab.Settings -> SettingsScreen(
                modifier = Modifier.padding(padding),
                darkTheme = darkTheme,
                onThemeChanged = onThemeChanged
            )
        }
    }
}
