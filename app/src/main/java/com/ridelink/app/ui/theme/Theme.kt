package com.ridelink.app.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF8EAEFF),
    onPrimary = Color(0xFF102B60),
    secondary = Color(0xFFB5C7E9),
    background = Color(0xFF101114),
    surface = Color(0xFF191B20),
    surfaceVariant = Color(0xFF252830),
    onBackground = Color(0xFFE7E9EF),
    onSurface = Color(0xFFE7E9EF),
    onSurfaceVariant = Color(0xFFBEC4D0)
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF245DCE),
    onPrimary = Color.White,
    secondary = Color(0xFF52627A),
    background = Color(0xFFF7F8FA),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFEEF1F6),
    onBackground = Color(0xFF191B20),
    onSurface = Color(0xFF191B20),
    onSurfaceVariant = Color(0xFF454B56)
)

@Composable
fun RideLinkTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
