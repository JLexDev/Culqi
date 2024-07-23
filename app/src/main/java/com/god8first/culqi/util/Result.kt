package com.god8first.culqi.util

/**
 * @author Alexander Ramírez on 21/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

/*
  Manage results of operations
 */
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val error: String) : Result<Nothing>()
}