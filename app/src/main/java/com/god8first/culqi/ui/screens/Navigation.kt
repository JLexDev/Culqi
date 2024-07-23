package com.god8first.culqi.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.god8first.culqi.ui.screens.nav.DashboardScreen
import com.god8first.culqi.ui.screens.SignInScreen
import com.god8first.culqi.ui.screens.SignUpScreen
import com.god8first.culqi.ui.screens.StartScreen

/**
 * @author Alexander Ramírez on 20/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/
 
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "StartScreen" //Screens.Login.route
    ) {

        composable(route = "StartScreen") {
            StartScreen(navController)
        }
        /*composable(route = "SignInScreen") {
            SignInScreen(navController)
        }*/
        composable(
            route = "SignInScreen/{email}",
            arguments = listOf(
                navArgument("email") { type = NavType.StringType }
            )
        ) {backStackEntry ->
            SignInScreen(
                emailArg = backStackEntry.arguments?.getString("email"),
                navController = navController
            )
        }
        composable(route = "SignUpScreen") {
            SignUpScreen(navController)
        }

        composable(route = "DashboardScreen") {
            DashboardScreen()
        }
    }
}