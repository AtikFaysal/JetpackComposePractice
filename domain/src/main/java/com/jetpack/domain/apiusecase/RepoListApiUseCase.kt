package com.jetpack.domain.apiusecase

import com.jetpack.apientity.RepoApiResponseItemEntity
import com.jetpack.domain.repository.RepoRepository
import com.jetpack.domain.usecase.ApiUseCaseParams
import javax.inject.Inject

class RepoListApiUseCase @Inject constructor(
    private val repository: RepoRepository,
): ApiUseCaseParams<RepoListApiUseCase.Params, List<RepoApiResponseItemEntity>> {

    data class Params(
        var userName:String,
    )

    override suspend fun execute(params: Params) = repository.fetchRepoList(params)
}