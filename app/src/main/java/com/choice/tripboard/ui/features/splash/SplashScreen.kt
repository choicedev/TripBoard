package com.choice.tripboard.ui.features.splash

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.choice.tripboard.R
import com.choice.tripboard.ui.components.composable.LoadingDots
import com.choice.tripboard.ui.components.icon.Route
import com.choice.tripboard.ui.features.splash.model.SplashDestination
import com.tripboard.app.ui.theme.TripTheme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds



@Composable
fun SplashScreen(
    onNavigate: (SplashDestination) -> Unit,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    val colors = TripTheme.colors
    val typography = TripTheme.typography

    var animationStarted by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        delay(100.milliseconds)
        animationStarted = true
    }

    LaunchedEffect(state.destination) {
        state.destination?.let(onNavigate)
    }

    val scale by animateFloatAsState(
        targetValue = if (animationStarted) 1f else 0.75f,
        animationSpec = tween(
            durationMillis = 700,
            easing = FastOutSlowInEasing
        ),
        label = "splashScale"
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colors.gradientHero)
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {

        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .scale(scale),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .size(96.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(Color.White.copy(alpha = 0.10f)),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    imageVector = Icons.Outlined.Route,
                    contentDescription = null,
                    modifier = Modifier.size(56.dp),
                    tint = Color.White
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = stringResource(R.string.app_name),
                style = typography.displaySmall.copy(
                    fontWeight = FontWeight.Bold
                ),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(R.string.splash_plan_share),
                style = typography.bodyMedium,
                color = Color.White.copy(alpha = 0.85f)
            )
        }

        LoadingDots(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp)
        )
    }
}

