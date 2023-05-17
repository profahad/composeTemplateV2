package com.fahad.samples.compose_template_ii.ui.components.textfields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fahad.samples.compose_template_ii.ui.theme.DarkBlue80
import com.fahad.samples.compose_template_ii.ui.theme.Korto
import com.fahad.samples.compose_template_ii.ui.theme.LightGray
import com.fahad.samples.compose_template_ii.ui.theme.LightGray5

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormTextFieldSimple(
    caption: String = "",
    placeholder: String = "",
    text: String? = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    onValueChanged: (String) -> Unit
) {
    val textState = remember { mutableStateOf(TextFieldValue(text ?: "")) }
    val isPasswordVisible = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = caption,
            fontFamily = Korto,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = DarkBlue80
        )
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .border(BorderStroke(1.dp, LightGray5), CircleShape),
            contentAlignment = Alignment.TopCenter
        ) {
            TextField(value = textState.value,
                onValueChange = {
                    textState.value = it
                    onValueChanged.invoke(it.text)
                },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = {
                    Text(
                        placeholder,
                        color = LightGray,
                        fontFamily = Korto,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = DarkBlue80,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = Color.Transparent,
                    cursorColor = DarkBlue80
                ),
                textStyle = TextStyle(
                    color = DarkBlue80,
                    fontFamily = Korto,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                ),
                visualTransformation = if (keyboardType == KeyboardType.Password && !isPasswordVisible.value) PasswordVisualTransformation() else VisualTransformation.None,
                trailingIcon = {
                    if (keyboardType == KeyboardType.Password && textState.value.text.isNotEmpty()) {
                        IconButton(onClick = {
                            isPasswordVisible.value = !isPasswordVisible.value
                        }) {
                            val icon =
                                if (isPasswordVisible.value) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                            Icon(
                                imageVector = icon, tint = LightGray, contentDescription = null
                            )
                        }
                    }
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FormTextFieldSimplePreview() {
    FormTextFieldSimple(
        caption = "Email",
        placeholder = "Enter email",
        text = "12345",
        keyboardType = KeyboardType.Email
    ) {

    }
}