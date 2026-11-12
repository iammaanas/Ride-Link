package com.ridelink.app

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class Rider(
    val id: String,
    val name: String,
    val deviceName: String
)

/**
 * UI-level session state shared by all four app destinations.
 * Real transport and persistence will be connected in a later milestone.
 */
class RideLinkSessionState {
    var isConnected by mutableStateOf(false)
        private set

    val riders = mutableStateListOf<Rider>()
}
