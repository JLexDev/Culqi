package com.god8first.culqi.util

/**
 * @author Alexander Ramírez on 19/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

sealed class Screens(val route: String) {

    object Dashboard : Screens("dashboard")

    object Auth : Screens("auth") {
        object Start : Screens("start")
        object SignIn : Screens("sign_in")
        object SignUp : Screens("sign_up")
    }
}