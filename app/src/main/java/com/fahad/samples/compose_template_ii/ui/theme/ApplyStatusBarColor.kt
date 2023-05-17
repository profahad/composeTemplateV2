package com.fahad.samples.compose_template_ii.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ApplyStatusBarColor(color: Color = Color.White, darkIcons: Boolean = true) {
    val systemUiController = rememberSystemUiController()
    val context = LocalContext.current

    DisposableEffect(key1 = context) {
        // Set the status bar color to white
        systemUiController.setSystemBarsColor(
            color = color,
            darkIcons = darkIcons
        )

        // Restore the status bar color when the composable is removed from the composition
        onDispose {
            onDispose {
                // Restore the status bar color when the composable is removed from the composition
                systemUiController.setStatusBarColor(Color.White)
            }
        }
    }
}