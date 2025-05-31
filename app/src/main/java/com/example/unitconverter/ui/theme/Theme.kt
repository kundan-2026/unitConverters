// app/src/main/java/com/example/unitconverter/ui/theme/Theme.kt
package com.example.unitconverter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    onPrimary = White,
    primaryContainer = Purple80,
    onPrimaryContainer = Purple40,
    secondary = PurpleGrey40,
    onSecondary = White,
    secondaryContainer = PurpleGrey80,
    onSecondaryContainer = PurpleGrey40,
    tertiary = Pink40,
    onTertiary = White,
    tertiaryContainer = Pink80,
    onTertiaryContainer = Pink40,
    background = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1C1B1F),
    surface = Color(0xFFFFFBFE),
    onSurface = Color(0xFF1C1B1F),
    surfaceVariant = Color(0xFFE7E0EC),
    onSurfaceVariant = Color(0xFF49454F),
    outline = Color(0xFF79747E)
)

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    onPrimary = Black,
    primaryContainer = Purple40,
    onPrimaryContainer = Purple80,
    secondary = PurpleGrey80,
    onSecondary = Black,
    secondaryContainer = PurpleGrey40,
    onSecondaryContainer = PurpleGrey80,
    tertiary = Pink80,
    onTertiary = Black,
    tertiaryContainer = Pink40,
    onTertiaryContainer = Pink80,
    background = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1E5),
    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFE6E1E5),
    surfaceVariant = Color(0xFF49454F),
    onSurfaceVariant = Color(0xFFCAC4D0),
    outline = Color(0xFF938F99)
)

@Composable
fun UnitConverterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}