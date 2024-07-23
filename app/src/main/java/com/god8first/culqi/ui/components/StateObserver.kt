package com.god8first.culqi.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import com.god8first.culqi.util.UIState
import kotlinx.coroutines.flow.StateFlow

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Composable
fun <T> StateObserver(
    state: StateFlow<UIState<T>>,
    onIdle: @Composable () -> Unit = {},
    onLoading: @Composable () -> Unit = { CircularProgressIndicator() },
    onSuccess: @Composable (T) -> Unit,
    onError: @Composable (String) -> Unit = {errorMessage ->
        Text(text = errorMessage, color = Color.Red)
    }
) {

    val uiState by state.collectAsState()

    when(uiState) {
        is UIState.Idle -> onIdle()
        is UIState.Loading -> onLoading()
        is UIState.Success -> onSuccess((uiState as UIState.Success<T>).response)
        is UIState.Error -> onError((uiState as UIState.Error).message)
    }
}