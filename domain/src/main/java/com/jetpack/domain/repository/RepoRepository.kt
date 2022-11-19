package com.jetpack.domain.repository


import com.jetpack.apientity.ProfileApiEntity
import com.jetpack.apientity.RepoApiResponseItemEntity
import com.jetpack.domain.apiusecase.ProfileApiUseCase
import com.jetpack.domain.apiusecase.RepoListApiUseCase
import com.jetpack.domain.base.ApiResult
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    suspend fun fetchRepoList(params: RepoListApiUseCase.Params): Flow<ApiResult<List<RepoApiResponseItemEntity>>>

    suspend fun fetchProfile(params: ProfileApiUseCase.Params): Flow<ApiResult<ProfileApiEntity>>

}