package com.god8first.culqi.di

import com.god8first.culqi.data.remote.ApiService
import com.god8first.culqi.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Alexander Ramírez on 22/07/2024.
 * ·
 * @JLexDev - 1jlex3@gmail.com
 **/

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        apiService: ApiService
    ): UserRepository {
        return UserRepository(apiService)
    }
}
