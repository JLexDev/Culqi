package com.god8first.culqi.domain.viewmodel

import androidx.lifecycle.viewModelScope
import com.god8first.culqi.data.repository.MyResourceRepository
import com.god8first.culqi.domain.response.MyResourceResponse
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
class DashboardViewModel @Inject constructor(
    private val myResourceRepository: MyResourceRepository
): BaseViewModel<MyResourceResponse>() {

    fun getMyResourcesList() {
        viewModelScope.launch {
            handleApiCall { myResourceRepository.getMyResourcesList() }
        }
    }
}