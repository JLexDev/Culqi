package com.god8first.culqi.util

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/
/*
  Manage the current status of the UI
 */
sealed class UIState<out T> {
    object Idle: UIState<Nothing>()
    object Loading: UIState<Nothing>()
    data class Success<out T>(val response: T) : UIState<T>()
    data class Error(val message: String) : UIState<Nothing>()
}