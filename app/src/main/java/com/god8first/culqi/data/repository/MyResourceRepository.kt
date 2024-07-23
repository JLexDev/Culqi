package com.god8first.culqi.data.repository

import com.god8first.culqi.data.remote.ApiService
import com.god8first.culqi.data.repository.base.BaseRepository
import com.god8first.culqi.domain.response.MyResourceResponse
import com.god8first.culqi.util.Result
import javax.inject.Inject

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

class MyResourceRepository @Inject constructor(
    private val apiService: ApiService
): BaseRepository() {

    suspend fun getMyResourcesList(): Result<MyResourceResponse> {
        return executeApi { apiService.getMyResourcesList() }
    }
}