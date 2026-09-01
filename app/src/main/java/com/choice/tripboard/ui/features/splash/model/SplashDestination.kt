package com.choice.tripboard.ui.features.splash.model

sealed interface SplashDestination {

    data object Onboarding : SplashDestination

    data object Login : SplashDestination

    data object Home : SplashDestination
}
