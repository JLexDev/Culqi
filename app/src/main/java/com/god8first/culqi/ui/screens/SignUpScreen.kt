package com.god8first.culqi.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.god8first.culqi.R
import com.god8first.culqi.components.BlurredBackgroundComponent
import com.god8first.culqi.components.HeadingTextComponent
import com.god8first.culqi.components.ImageComponent
import com.god8first.culqi.components.MyButtonComponent
import com.god8first.culqi.components.MyTextField
import com.god8first.culqi.components.PasswordInputComponent
import com.god8first.culqi.components.TextSpanClickableComponent
import com.god8first.culqi.domain.viewmodel.AuthViewModel
import com.god8first.culqi.util.extension.toast
import com.god8first.culqi.ui.components.StateObserver
import com.god8first.culqi.ui.theme.CulqiTheme

/**
 * @author Alexander Ramírez on 20/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Composable
fun SignUpScreen(navController: NavHostController, viewModel: AuthViewModel = hiltViewModel()) {

    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    StateObserver(
        state = viewModel.uiState,
        onIdle = {
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
                        HeadingTextComponent(title = "Regístrate")
                        Spacer(modifier = Modifier.height(20.dp))

                        BlurredBackgroundComponent {
                            Column {
                                /*Text(text = "Parece que no tienes cuenta. Crea una nueva cuenta para")
                                val email = "1jlex3@gmail.com"
                                Text(text = email, fontWeight = FontWeight.Bold)*/
                                Text(text = "Crea una cuenta nueva")
                                Spacer(modifier = Modifier.height(20.dp))
                                MyTextField(
                                    label = "Correo",
                                    onValueChange = { newValue ->
                                        email = newValue
                                    }
                                )
                                Spacer(modifier = Modifier.height(15.dp))
                                PasswordInputComponent(
                                    label = "Contraseña",
                                    onValueChange = { newValue ->
                                        password = newValue
                                    }
                                )

                                Spacer(modifier = Modifier.height(20.dp))
                                TextSpanClickableComponent(
                                    initialText = "Seleccionando Aceptar y continuar, estás de acuerdo con los ",
                                    clickableText = "Términos de Servicio y Política de Privacidad"
                                ) {
                                    context.toast("TermsScreen")
                                }
                                Spacer(modifier = Modifier.height(20.dp))
                                MyButtonComponent(label = "Aceptar y continuar") {
                                    viewModel.signUp(email, password)
                                }
                                Spacer(modifier = Modifier.height(10.dp))
                            }
                        }
                    }
                }
            }
        },
        onLoading = { },
        onSuccess = { userResponse ->
            context.toast("Id: ${userResponse.id}\nToken: ${userResponse.token}")
            navController.navigate("DashboardScreen")
        },
        onError = { errorMessage ->
            context.toast("Error: $errorMessage")
        }
    )
}


@Preview
@Composable
fun SignUpScreenPreview() {
    CulqiTheme {
        //SignUpScreen()
    }
}