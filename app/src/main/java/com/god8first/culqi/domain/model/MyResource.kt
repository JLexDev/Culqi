package com.god8first.culqi.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * @author Alexander Ramírez on 21/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Parcelize
data class MyResource(
    val id: Int,
    val name: String,
    val year: Int,
    val color: String,
    val pantone_value: String
): Parcelable
