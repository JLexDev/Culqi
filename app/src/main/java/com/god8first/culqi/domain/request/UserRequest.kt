package com.god8first.culqi.domain.request

import com.google.gson.annotations.SerializedName

/**
 * @author Alexander Ramírez on 21/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

data class UserRequest(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)
