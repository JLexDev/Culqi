package com.god8first.culqi.util.extension

import android.content.Context
import android.widget.Toast

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

fun Context.toast(message: String?, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}