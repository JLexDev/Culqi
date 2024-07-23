package com.god8first.culqi.data.repository.base

import com.god8first.culqi.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

open class BaseRepository {

    suspend fun <T> executeApi(apiCall: suspend () -> T): Result<T> {
        return withContext(Dispatchers.IO) {
            try {
                Result.Success(apiCall())
            } catch (e: Exception) {
                Result.Failure("Network error: ${e.message}")
            }
        }
    }
}