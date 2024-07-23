package com.god8first.culqi.domain.viewmodel

import androidx.lifecycle.viewModelScope
import com.god8first.culqi.data.repository.UserRepository
import com.god8first.culqi.domain.response.UserResponse
import com.god8first.culqi.domain.viewmodel.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
): BaseViewModel<UserResponse>() {

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            handleApiCall { userRepository.signIn(email, password) }
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            handleApiCall { userRepository.signUp(email, password) }
        }
    }
}