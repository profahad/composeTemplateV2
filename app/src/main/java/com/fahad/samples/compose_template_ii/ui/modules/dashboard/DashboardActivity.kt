package com.fahad.samples.compose_template_ii.ui.modules.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fahad.samples.compose_template_ii.ui.modules.dashboard.screens.DashboardScreen
import com.fahad.samples.compose_template_ii.ui.routes.Route
import com.fahad.samples.compose_template_ii.ui.theme.TemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : ComponentActivity() {

    companion object {
        fun createInstance(context: Context) = Intent(context, DashboardActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TemplateTheme {
                JetpackComposeAppScreen()
            }
        }
    }
}

@Composable
fun JetpackComposeAppScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Route.Dashboard.route,
    ) {
        composable(route = Route.Dashboard.route) {
            DashboardScreen(navController)
        }
    }
}