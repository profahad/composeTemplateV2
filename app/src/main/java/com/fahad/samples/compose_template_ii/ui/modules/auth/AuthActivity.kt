package com.fahad.samples.compose_template_ii.ui.modules.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fahad.samples.compose_template_ii.ui.modules.auth.screens.landing.AuthLandingScreen
import com.fahad.samples.compose_template_ii.ui.modules.auth.screens.login.LoginScreen
import com.fahad.samples.compose_template_ii.ui.modules.auth.screens.signUp.SignUpScreen
import com.fahad.samples.compose_template_ii.ui.routes.Route
import com.fahad.samples.compose_template_ii.ui.theme.TemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthActivity : ComponentActivity() {

    companion object {
        fun createInstance(context: Context) = Intent(context, AuthActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                AuthLaunchScreen()
            }
        }
    }
}

@Composable
fun AuthLaunchScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.AuthLanding.route,
    ) {
        composable(route = Route.AuthLanding.route) {
            AuthLandingScreen(navController)
        }
        composable(route = Route.Login.route) {
            LoginScreen(navController, loginViewModel = hiltViewModel())
        }
        composable(route = Route.SignUp.route) {
            SignUpScreen(navController, signUpViewModel = hiltViewModel())
        }
    }
}