package com.jetpack.compose.di

import com.jetpack.data.repoimpl.RepoRepoImpl
import com.jetpack.domain.repository.RepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindRepoRepository(credentialRepoImpl: RepoRepoImpl): RepoRepository
}