package com.god8first.culqi.domain.response

import com.google.gson.annotations.SerializedName

/**
 * @author Alexander Ramírez on 21/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

data class UserResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("token") val token: String
)
