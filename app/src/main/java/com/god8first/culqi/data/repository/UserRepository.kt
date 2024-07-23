package com.god8first.culqi.data.repository

import com.god8first.culqi.data.remote.ApiService
import com.god8first.culqi.data.repository.base.BaseRepository
import com.god8first.culqi.domain.request.UserRequest
import com.god8first.culqi.domain.response.UserResponse
import com.god8first.culqi.util.Result
import javax.inject.Inject

/**
 * @author Alexander Ramírez on 21/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

class UserRepository @Inject constructor(
    private val apiService: ApiService
): BaseRepository() {

    suspend fun signIn(email: String, password: String): Result<UserResponse> {
        return executeApi { apiService.signIn(UserRequest(email, password)) }
    }

    suspend fun signUp(email: String, password: String): Result<UserResponse> {
        return executeApi { apiService.signUp(UserRequest(email, password)) }
    }
}