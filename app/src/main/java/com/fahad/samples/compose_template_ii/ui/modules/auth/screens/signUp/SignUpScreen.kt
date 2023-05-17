package com.fahad.samples.compose_template_ii.ui.modules.auth.screens.signUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.fahad.samples.compose_template_ii.R
import com.fahad.samples.compose_template_ii.ui.components.buttons.SocialButton
import com.fahad.samples.compose_template_ii.ui.components.buttons.StandardButton
import com.fahad.samples.compose_template_ii.ui.components.textfields.FormTextFieldSimple
import com.fahad.samples.compose_template_ii.ui.components.views.LineView
import com.fahad.samples.compose_template_ii.ui.routes.Route
import com.fahad.samples.compose_template_ii.ui.theme.ApplyStatusBarColor
import com.fahad.samples.compose_template_ii.ui.theme.DarkBlue80
import com.fahad.samples.compose_template_ii.ui.theme.DarkGray
import com.fahad.samples.compose_template_ii.ui.theme.Korto
import com.fahad.samples.compose_template_ii.ui.theme.LightGray
import com.fahad.samples.compose_template_ii.ui.theme.LightGray10
import com.fahad.samples.compose_template_ii.ui.theme.LightGray40

@Composable
fun SignUpScreen(
    navController: NavController, signUpViewModel: SignUpViewModel? = null
) {
    val signUpResponse = signUpViewModel?.signUpResponse?.collectAsState()

    ApplyStatusBarColor()
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = "Logo",
                        modifier = Modifier
                            .size(40.dp)
                            .shadow(1.dp, shape = CircleShape)
                            .background(LightGray40, shape = CircleShape)
                            .border(1.dp, shape = CircleShape, color = LightGray10)
                            .padding(8.dp),
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        text = "Leafboard",
                        fontFamily = Korto,
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = DarkBlue80
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Work without limits",
                    fontFamily = Korto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = DarkBlue80
                )
            }

            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                FormTextFieldSimple(
                    caption = "Your First Name",
                    placeholder = "First Name",
                    keyboardType = KeyboardType.Text,
                    text = signUpViewModel?.signUpRequest?.value?.firstName
                ) {
                    signUpViewModel?.setFirstName(it)
                }
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                )
                FormTextFieldSimple(
                    caption = "Your Last Name",
                    placeholder = "Last Name",
                    keyboardType = KeyboardType.Text,
                    text = signUpViewModel?.signUpRequest?.value?.lastName
                ) {
                    signUpViewModel?.setLastName(it)
                }
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                )
                FormTextFieldSimple(
                    caption = "Your Email Address",
                    placeholder = "email@mail.com",
                    keyboardType = KeyboardType.Email,
                    text = signUpViewModel?.signUpRequest?.value?.email
                ) {
                    signUpViewModel?.setEmail(it)
                }
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                )
                FormTextFieldSimple(
                    caption = "Choose a password",
                    placeholder = "min. 8 characters",
                    keyboardType = KeyboardType.Password,
                    text = signUpViewModel?.signUpRequest?.value?.password
                ) {
                    signUpViewModel?.setPassword(it)
                }
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth()
                )
                FormTextFieldSimple(
                    caption = "Confirm password",
                    placeholder = "min. 8 characters",
                    keyboardType = KeyboardType.Password,
                    text = signUpViewModel?.signUpRequest?.value?.password
                ) {
                    signUpViewModel?.setPassword(it)
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            StandardButton(text = "Sign Up", visibleImage = true) {
                navController.navigate(Route.Login.route)
            }

            Box(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                LineView(
                    modifier = Modifier.fillMaxWidth(), width = 2.0f, color = LightGray
                )
                Text(
                    text = "or",
                    fontFamily = Korto,
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = DarkGray,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            SocialButton(text = "Sign Up with Google", icon = R.drawable.ic_google) {

            }
            Spacer(modifier = Modifier.height(16.dp))
            SocialButton(text = "Sign Up with Facebook", icon = R.drawable.ic_facebook) {

            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    val navController = rememberNavController()
    SignUpScreen(navController)
}