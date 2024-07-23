package com.god8first.culqi.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.god8first.culqi.R
import com.god8first.culqi.components.BlurredBackgroundComponent
import com.god8first.culqi.components.HeadingTextComponent
import com.god8first.culqi.components.ImageComponent
import com.god8first.culqi.components.MyButtonComponent
import com.god8first.culqi.components.MyTextField
import com.god8first.culqi.components.SocialNetworkButtonComponent
import com.god8first.culqi.components.TextClickableComponent
import com.god8first.culqi.components.TextSpanClickableComponent
import com.god8first.culqi.util.extension.toast
import com.god8first.culqi.ui.theme.CulqiTheme

/**
 * @author Alexander Ramírez on 20/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Composable
fun StartScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") } // { mutableStateOf("eve.holt@reqres.in") }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        ImageComponent(image = R.drawable.ic_culqi_background)

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            color = Color.Transparent
        ) {
            Column {
                Spacer(modifier = Modifier.height(100.dp))
                HeadingTextComponent(title = "¡Hola!")
                Spacer(modifier = Modifier.height(20.dp))

                BlurredBackgroundComponent {
                    Column {
                        MyTextField(
                            label = "Correo",
                            onValueChange = { newValue ->
                                email = newValue
                            }
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        MyButtonComponent(label = "Continuar") {
                            navController.navigate("SignInScreen/$email")
                        }

                        Spacer(modifier = Modifier.height(15.dp))
                        Text(text = "o", color = Color.White, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
                        /*Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "o", color = Color.White, textAlign = TextAlign.Center)
                        }*/
                        Spacer(modifier = Modifier.height(15.dp))

                        SocialNetworkButtonComponent(label = "Facebook", icon = R.drawable.ic_facebook)
                        Spacer(modifier = Modifier.height(15.dp))
                        SocialNetworkButtonComponent(label = "Google", icon = R.drawable.ic_google)
                        Spacer(modifier = Modifier.height(15.dp))
                        SocialNetworkButtonComponent(label = "Apple", icon = R.drawable.ic_apple)

                        Spacer(modifier = Modifier.height(25.dp))

                        TextSpanClickableComponent(
                            initialText = "¿No tienes cuenta?  ",
                            clickableText = "Regístrate"
                        ) {
                            navController.navigate("SignUpScreen")
                        }
                        Spacer(modifier = Modifier.height(25.dp))
                        TextClickableComponent(label = "¿Olvidaste tu contraseña?") {
                            context.toast("ForgotScreen")
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun StartScreenPreview() {
    CulqiTheme {
        //StartScreen()
    }
}