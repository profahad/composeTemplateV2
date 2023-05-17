package com.fahad.samples.compose_template_ii.ui.routes

sealed class Route(val route: String) {
    object Dashboard : Route("Dashboard")
    object Home : Route("Home")
    object AuthLanding : Route("AuthLanding")
    object Login : Route("Login")
    object SignUp : Route("SignUp")
}