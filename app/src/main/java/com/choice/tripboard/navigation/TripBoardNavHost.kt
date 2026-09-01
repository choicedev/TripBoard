package com.tripboard.app.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.choice.tripboard.navigation.Route
import com.choice.tripboard.ui.features.splash.SplashScreen
import com.choice.tripboard.ui.features.splash.model.SplashDestination

@Composable
fun TripBoardNavHost(
    navController: NavHostController,
    startDestination: Route = Route.Splash
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        // Splash
        composable<Route.Splash> {

            SplashScreen(
                onNavigate = { destination ->

                    when (destination) {

                        SplashDestination.Onboarding -> {
/*                            navController.navigate(Route.Onboarding) {
                                popUpTo<Route.Splash> {
                                    inclusive = true
                                }
                            }*/
                        }

                        SplashDestination.Login -> {
                            navController.navigate(Route.Login) {
                                popUpTo<Route.Splash> {
                                    inclusive = true
                                }
                            }
                        }

                        SplashDestination.Home -> {
                            navController.navigate(Route.Home) {
                                popUpTo<Route.Splash> {
                                    inclusive = true
                                }
                            }
                        }
                    }
                }
            )
        }

        composable<Route.Onboarding> {

        }
    }
}