package com.jetpack.data.service

import com.jetpack.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiServicesModule {
    @Provides
    @Singleton
    fun provideRepoApiServices(
        @AppBaseUrl retrofit: Retrofit,
    ): RepoApiServices {
        return retrofit.create(RepoApiServices::class.java)
    }
}