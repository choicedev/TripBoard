package com.choice.tripboard.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data object Splash : Route

    @Serializable
    data object Onboarding : Route

    @Serializable
    data object Login : Route

    @Serializable
    data object Home : Route

    @Serializable
    data object CreateTrip : Route

    @Serializable
    data object JoinTrip : Route

    @Serializable
    data object Scanner : Route

    @Serializable
    data object EnterCode : Route

    @Serializable
    data class TripPreview(
        val shareCode: String
    ) : Route

    @Serializable
    data class TripDashboard(
        val tripId: String
    ) : Route

    @Serializable
    data class Itinerary(
        val tripId: String
    ) : Route

    @Serializable
    data class Activity(
        val tripId: String,
        val activityId: String? = null
    ) : Route

    @Serializable
    data class TripMap(
        val tripId: String
    ) : Route

    @Serializable
    data class Expenses(
        val tripId: String
    ) : Route

    @Serializable
    data class CreateExpense(
        val tripId: String,
        val expenseId: String? = null
    ) : Route

    @Serializable
    data class ExpenseSplit(
        val tripId: String
    ) : Route

    @Serializable
    data class Members(
        val tripId: String
    ) : Route

    @Serializable
    data class Lodging(
        val tripId: String
    ) : Route

    @Serializable
    data class Transport(
        val tripId: String
    ) : Route

    @Serializable
    data class Checklist(
        val tripId: String
    ) : Route

    @Serializable
    data class ShareTrip(
        val tripId: String
    ) : Route

    @Serializable
    data class TripSettings(
        val tripId: String
    ) : Route
}