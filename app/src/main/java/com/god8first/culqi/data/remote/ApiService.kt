package com.god8first.culqi.data.remote

import com.god8first.culqi.domain.request.UserRequest
import com.god8first.culqi.domain.response.MyResourceResponse
import com.god8first.culqi.domain.response.UserResponse
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * @author Alexander Ramírez on 21/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

interface ApiService {

    @POST("api/login")
    suspend fun signIn(@Body request: UserRequest): UserResponse

    @POST("api/register")
    suspend fun signUp(@Body request: UserRequest): UserResponse

    @GET("api/unknown")
    suspend fun getMyResourcesList(): MyResourceResponse
}