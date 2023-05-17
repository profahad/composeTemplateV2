package com.fahad.samples.compose_template_ii.ui.components.views

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.fahad.samples.compose_template_ii.ui.theme.LightGray


@Composable
fun LineView(
    modifier: Modifier,
    width: Float,
    color: Color
) {
    Canvas(
        modifier = modifier
    ) {
        drawLine(
            color = color,
            start = Offset(0f, 0f),
            end = Offset(size.width, size.height),
            strokeWidth = width,
            alpha = 1f,
            cap = StrokeCap.Round
        )
    }
}