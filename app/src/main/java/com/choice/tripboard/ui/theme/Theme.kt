package com.tripboard.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.choice.tripboard.ui.theme.*

data class AppShadow(val color: Color, val elevation: Dp)

fun Modifier.dropShadow(shadow: AppShadow, shape: Shape = AppTripShapes.lg): Modifier =
    this.shadow(
        elevation = shadow.elevation,
        shape = shape,
        ambientColor = shadow.color,
        spotColor = shadow.color
    )

data class TripColors(
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val card: Color,
    val onCard: Color,
    val popover: Color,
    val onPopover: Color,
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val muted: Color,
    val onMuted: Color,
    val accent: Color,
    val onAccent: Color,
    val destructive: Color,
    val onDestructive: Color,
    val success: Color,
    val onSuccess: Color,
    val warning: Color,
    val onWarning: Color,
    val border: Color,
    val input: Color,
    val ring: Color,
    val chart1: Color,
    val chart2: Color,
    val chart3: Color,
    val chart4: Color,
    val chart5: Color,
    val sidebar: Color,
    val onSidebar: Color,
    val sidebarPrimary: Color,
    val onSidebarPrimary: Color,
    val sidebarAccent: Color,
    val onSidebarAccent: Color,
    val sidebarBorder: Color,
    val sidebarRing: Color,
    val gradientHero: Brush,
    val gradientAccent: Brush,
    val shadowCard: AppShadow,
    val shadowFloat: AppShadow
)

private val HeroGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF2C5C63),
        L_Primary,
        Color(0xFFD79A55)
    )
)
private val AccentGradient = Brush.linearGradient(colors = listOf(L_Accent, L_Warning))

val LightTripColors = TripColors(
    background = L_Background,
    onBackground = L_Foreground,
    surface = L_Surface,
    card = L_Card,
    onCard = L_CardForeground,
    popover = L_Popover,
    onPopover = L_PopoverForeground,
    primary = L_Primary,
    onPrimary = L_PrimaryForeground,
    secondary = L_Secondary,
    onSecondary = L_SecondaryForeground,
    muted = L_Muted,
    onMuted = L_MutedForeground,
    accent = L_Accent,
    onAccent = L_AccentForeground,
    destructive = L_Destructive,
    onDestructive = L_DestructiveForeground,
    success = L_Success,
    onSuccess = L_SuccessForeground,
    warning = L_Warning,
    onWarning = L_WarningForeground,
    border = L_Border,
    input = L_Input,
    ring = L_Ring,
    chart1 = L_Chart1,
    chart2 = L_Chart2,
    chart3 = L_Chart3,
    chart4 = L_Chart4,
    chart5 = L_Chart5,
    sidebar = L_Sidebar,
    onSidebar = L_SidebarForeground,
    sidebarPrimary = L_SidebarPrimary,
    onSidebarPrimary = L_SidebarPrimaryForeground,
    sidebarAccent = L_SidebarAccent,
    onSidebarAccent = L_SidebarAccentForeground,
    sidebarBorder = L_SidebarBorder,
    sidebarRing = L_SidebarRing,
    gradientHero = HeroGradient,
    gradientAccent = AccentGradient,
    shadowCard = AppShadow(color = Color(0x2E0C2422), elevation = 24.dp),
    shadowFloat = AppShadow(color = Color(0x590C2422), elevation = 32.dp)
)

val DarkTripColors = TripColors(
    background = D_Background,
    onBackground = D_Foreground,
    surface = D_Surface,
    card = D_Card,
    onCard = D_CardForeground,
    popover = D_Popover,
    onPopover = D_PopoverForeground,
    primary = D_Primary,
    onPrimary = D_PrimaryForeground,
    secondary = D_Secondary,
    onSecondary = D_SecondaryForeground,
    muted = D_Muted,
    onMuted = D_MutedForeground,
    accent = D_Accent,
    onAccent = D_AccentForeground,
    destructive = L_Destructive,
    onDestructive = L_DestructiveForeground,
    success = L_Success,
    onSuccess = L_SuccessForeground,
    warning = L_Warning,
    onWarning = L_WarningForeground,
    border = D_Border,
    input = D_Input,
    ring = D_Ring,
    chart1 = L_Chart1,
    chart2 = L_Chart2,
    chart3 = L_Chart3,
    chart4 = L_Chart4,
    chart5 = L_Chart5,
    sidebar = L_Sidebar,
    onSidebar = L_SidebarForeground,
    sidebarPrimary = L_SidebarPrimary,
    onSidebarPrimary = L_SidebarPrimaryForeground,
    sidebarAccent = L_SidebarAccent,
    onSidebarAccent = L_SidebarAccentForeground,
    sidebarBorder = L_SidebarBorder,
    sidebarRing = L_SidebarRing,
    gradientHero = HeroGradient,
    gradientAccent = AccentGradient,
    shadowCard = AppShadow(color = Color(0x2E0C2422), elevation = 24.dp),
    shadowFloat = AppShadow(color = Color(0x590C2422), elevation = 32.dp)
)

val LocalTripColors = staticCompositionLocalOf { LightTripColors }
val LocalTripShapes = staticCompositionLocalOf { AppTripShapes }

@Composable
fun TripBoardTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val tripColors = if (darkTheme) DarkTripColors else LightTripColors

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> darkColorScheme(
            primary = tripColors.primary,
            onPrimary = tripColors.onPrimary,
            primaryContainer = tripColors.secondary,
            onPrimaryContainer = tripColors.onSecondary,
            secondary = tripColors.secondary,
            onSecondary = tripColors.onSecondary,
            secondaryContainer = tripColors.muted,
            onSecondaryContainer = tripColors.onMuted,
            tertiary = tripColors.accent,
            onTertiary = tripColors.onAccent,
            background = tripColors.background,
            onBackground = tripColors.onBackground,
            surface = tripColors.card,
            onSurface = tripColors.onCard,
            surfaceVariant = tripColors.muted,
            onSurfaceVariant = tripColors.onMuted,
            error = tripColors.destructive,
            onError = tripColors.onDestructive,
            outline = tripColors.border,
            outlineVariant = tripColors.border
        )
        else -> lightColorScheme(
            primary = tripColors.primary,
            onPrimary = tripColors.onPrimary,
            primaryContainer = tripColors.secondary,
            onPrimaryContainer = tripColors.onSecondary,
            secondary = tripColors.secondary,
            onSecondary = tripColors.onSecondary,
            secondaryContainer = tripColors.muted,
            onSecondaryContainer = tripColors.onMuted,
            tertiary = tripColors.accent,
            onTertiary = tripColors.onAccent,
            background = tripColors.background,
            onBackground = tripColors.onBackground,
            surface = tripColors.card,
            onSurface = tripColors.onCard,
            surfaceVariant = tripColors.muted,
            onSurfaceVariant = tripColors.onMuted,
            error = tripColors.destructive,
            onError = tripColors.onDestructive,
            outline = tripColors.border,
            outlineVariant = tripColors.border
        )
    }

    CompositionLocalProvider(
        LocalTripColors provides tripColors,
        LocalTripShapes provides AppTripShapes
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            shapes = AppShapes,
            content = content
        )
    }
}

object TripTheme {
    val colors: TripColors
        @Composable get() = LocalTripColors.current

    val shapes: TripShapes
        @Composable get() = LocalTripShapes.current

    val typography: Typography
        @Composable get() = MaterialTheme.typography
}