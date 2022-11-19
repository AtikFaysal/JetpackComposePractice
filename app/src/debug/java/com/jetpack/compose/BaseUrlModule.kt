package com.jetpack.compose

import com.jetpack.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule{
    @Singleton
    @Provides
    @AppBaseUrl
    fun provideBaseUrl():String = "https://api.github.com/"
}

