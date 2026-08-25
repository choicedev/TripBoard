package com.choice.tripboard.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp


val RadiusSm = 12.dp
val RadiusMd = 14.dp
val RadiusLg = 16.dp
val RadiusXl = 20.dp
val Radius2xl = 24.dp
val Radius3xl = 28.dp
val Radius4xl = 32.dp

data class TripShapes(
    val sm: Shape,
    val md: Shape,
    val lg: Shape,
    val xl: Shape,
    val xl2: Shape,
    val xl3: Shape,
    val xl4: Shape
)

val AppTripShapes = TripShapes(
    sm = RoundedCornerShape(RadiusSm),
    md = RoundedCornerShape(RadiusMd),
    lg = RoundedCornerShape(RadiusLg),
    xl = RoundedCornerShape(RadiusXl),
    xl2 = RoundedCornerShape(Radius2xl),
    xl3 = RoundedCornerShape(Radius3xl),
    xl4 = RoundedCornerShape(Radius4xl)
)

val AppShapes = Shapes(
    extraSmall = RoundedCornerShape(RadiusSm),
    small = RoundedCornerShape(RadiusMd),
    medium = RoundedCornerShape(RadiusLg),
    large = RoundedCornerShape(RadiusXl),
    extraLarge = RoundedCornerShape(Radius2xl)
)