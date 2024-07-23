package com.god8first.culqi.domain.viewmodel.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.god8first.culqi.util.Result
import com.god8first.culqi.util.UIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

open class BaseViewModel<T> : ViewModel() {

    private val _uiState = MutableStateFlow<UIState<T>>(UIState.Idle)
    val uiState: StateFlow<UIState<T>> = _uiState.asStateFlow()

    protected fun setLoading() {
        _uiState.value = UIState.Loading
    }

    protected fun setSuccess(data: T) {
        _uiState.value = UIState.Success(data)
    }

    protected fun setError(message: String) {
        _uiState.value = UIState.Error(message)
    }

    protected fun handleApiCall(apiCall: suspend () -> Result<T>) {
        setLoading()
        viewModelScope.launch {
            val result = apiCall()
            when(result) {
                is Result.Success -> setSuccess(result.data)
                is Result.Failure -> setError(result.error)
            }
        }
    }
}