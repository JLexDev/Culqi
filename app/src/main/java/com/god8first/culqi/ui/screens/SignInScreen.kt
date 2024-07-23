package com.god8first.culqi.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
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
import com.god8first.culqi.components.PasswordInputComponent
import com.god8first.culqi.components.TextClickableComponent
import com.god8first.culqi.components.UsernameComponent
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
fun SignInScreen(emailArg: String?, navController: NavHostController, viewModel: AuthViewModel = hiltViewModel()) {

    val context = LocalContext.current
    val email by remember { mutableStateOf(emailArg ?: "") } // "eve.holt@reqres.in"
    var password by remember { mutableStateOf("") }          // "cityslicka"

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
                        HeadingTextComponent(title = "Iniciar sesión")
                        Spacer(modifier = Modifier.height(20.dp))

                        BlurredBackgroundComponent {
                            Column {
                                UsernameComponent(
                                    avatarId = R.drawable.ic_culqi_background,
                                    name = email.substringBefore("@"), //"Alexander Ramírez",
                                    email = email
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                PasswordInputComponent(
                                    label = "Contraseña",
                                    onValueChange = { newValue ->
                                        password = newValue
                                    }
                                )
                                Spacer(modifier = Modifier.height(15.dp))

                                MyButtonComponent(label = "Continuar") {
                                    viewModel.signIn(email, password)
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
        },
        onLoading = { /*LoadingComponent() | Fix version of animation's component*/ },
        onSuccess = { userResponse ->
            context.toast("Token: ${userResponse.token}")
            navController.navigate("DashboardScreen")
        },
        onError = { errorMessage ->
            context.toast("Error: $errorMessage")
        }
    )
}



@Preview
@Composable
fun SignInScreenPreview() {
    CulqiTheme {
        //SignInScreen()
    }
}