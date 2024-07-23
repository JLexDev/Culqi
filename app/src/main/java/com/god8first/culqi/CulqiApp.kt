package com.god8first.culqi

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.god8first.culqi.screens.Navigation

/**
 * @author Alexander Ramírez on 20/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Composable
fun CulqiApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Navigation()
    }
}