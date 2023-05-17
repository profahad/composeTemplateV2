package com.fahad.samples.compose_template_ii.ui.theme

import androidx.compose.ui.graphics.Color

val String.hexColor: Color
    get() {
        val colorString = if (this.startsWith("#")) {
            this.substring(1) // Remove the '#' prefix if present
        } else {
            this
        }

        return try {
            Color(android.graphics.Color.parseColor("#$colorString"))
        } catch (e: IllegalArgumentException) {
            Color.Unspecified
        }
    }

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val DarkBlue80 = "#131B2F".hexColor
val LightGray40 = "#F6F7F9".hexColor
val LightGray10 = "#FCFCFC".hexColor
val LightGray5 = "#E9EBF0".hexColor
val LightGray = "#9BA3B4".hexColor

val DarkGray = "#566078".hexColor


val LightGreen80 = "#B8F991".hexColor