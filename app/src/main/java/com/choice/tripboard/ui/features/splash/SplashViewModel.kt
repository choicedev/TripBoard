package com.choice.tripboard.ui.features.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.choice.tripboard.ui.features.splash.model.SplashDestination
import com.choice.tripboard.ui.features.splash.model.SplashUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class SplashViewModel @Inject constructor(): ViewModel() {

    private val _uiState = MutableStateFlow(SplashUiState())
    val uiState: StateFlow<SplashUiState> = _uiState.asStateFlow()

    init {
        resolveDestination()
    }

    private fun resolveDestination() {
        viewModelScope.launch {

            delay(500.milliseconds)

            val onboardingCompleted = false
            val hasSession = false

            val destination = when {
                !onboardingCompleted -> SplashDestination.Onboarding
                !hasSession -> SplashDestination.Login
                else -> SplashDestination.Home
            }

            _uiState.value = SplashUiState(
                isLoading = false,
                destination = destination
            )
        }
    }
}