package com.fahad.samples.compose_template_ii.ui.modules.auth.screens.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fahad.samples.compose_template_ii.R
import com.fahad.samples.compose_template_ii.ui.components.buttons.StandardButton
import com.fahad.samples.compose_template_ii.ui.routes.Route
import com.fahad.samples.compose_template_ii.ui.theme.DarkBlue80
import com.fahad.samples.compose_template_ii.ui.theme.Korto
import com.fahad.samples.compose_template_ii.ui.theme.LightGray10
import com.fahad.samples.compose_template_ii.ui.theme.LightGray40
import com.fahad.samples.compose_template_ii.ui.theme.ApplyStatusBarColor

@Composable
fun AuthLandingScreen(
    navController: NavController,
) {
    ApplyStatusBarColor(DarkBlue80, false)
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.92f)
                        .background(
                            DarkBlue80, shape = RoundedCornerShape(
                                topStart = CornerSize(0.5f),
                                topEnd = CornerSize(0),
                                bottomStart = CornerSize(percent = 30),
                                bottomEnd = CornerSize(percent = 30)
                            )
                        )
                ) {

                }
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(80.dp)
                            .shadow(1.dp, shape = CircleShape)
                            .background(LightGray40, shape = CircleShape)
                            .border(1.dp, shape = CircleShape, color = LightGray10)
                            .padding(8.dp),
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Leafboard",
                        fontFamily = Korto,
                        fontWeight = FontWeight.Medium,
                        fontSize = 40.sp,
                        color = DarkBlue80
                    )

                    Text(
                        text = "A platform built for a new way of working",
                        fontFamily = Korto,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = DarkBlue80,
                        modifier = Modifier.padding(top = 30.dp),
                    )
                }

                StandardButton(
                    text = "Get Started for Free",
                    visibleImage = true,
                    modifier = Modifier
                        .height(50.dp)
                ) {
                    navController.navigate(Route.Login.route)
                }

            }
        }
    }
}


@Preview
@Composable
fun AuthLandingScreenPreview() {
    val navController = rememberNavController()
    AuthLandingScreen(navController)
}