package com.fahad.samples.compose_template_ii.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahad.samples.compose_template_ii.R
import com.fahad.samples.compose_template_ii.ui.theme.DarkBlue80
import com.fahad.samples.compose_template_ii.ui.theme.Korto
import com.fahad.samples.compose_template_ii.ui.theme.LightGray
import com.fahad.samples.compose_template_ii.ui.theme.LightGreen80

@Composable
fun SocialButton(text: String, icon: Int, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        onClick = {
            onClick.invoke()
        },
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        shape = CircleShape,
        border = BorderStroke(1.dp, LightGray)
    ) {
        Image(
            painterResource(id = icon), contentDescription = "Logo", modifier = Modifier.size(18.dp)
        )
        Text(
            text = text,
            fontFamily = Korto,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = DarkBlue80,
            modifier = Modifier.padding(start = 10.dp),
        )
    }
}

@Composable
fun StandardButton(
    text: String,
    textColor: Color = DarkBlue80,
    backgroundColor: Color = LightGreen80,
    visibleImage: Boolean = false,
    icon: ImageVector = Icons.Default.KeyboardArrowRight,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = {
            onClick.invoke()
        },
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        elevation = ButtonDefaults.buttonElevation(1.dp, 2.dp, 2.dp, 2.dp, 1.dp)
    ) {
        Text(
            text = text,
            fontFamily = Korto,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = textColor,
            modifier = Modifier,
        )
        if (visibleImage) {
            Icon(
                icon, contentDescription = "Logo", tint = textColor
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SimpleButtonPreview() {
    SocialButton(text = "Sign In with Google", icon = R.drawable.ic_google) {

    }
}


@Preview(showBackground = true)
@Composable
fun StandardButtonPreview() {
    StandardButton(text = "Sign In with Google", visibleImage = true) {

    }
}