package com.jetpack.domain.apiusecase

import com.jetpack.apientity.ProfileApiEntity
import com.jetpack.domain.repository.RepoRepository
import com.jetpack.domain.usecase.ApiUseCaseParams
import javax.inject.Inject

class ProfileApiUseCase @Inject constructor(
    private val repository: RepoRepository,
): ApiUseCaseParams<ProfileApiUseCase.Params, ProfileApiEntity> {

    data class Params(
        var userName:String,
    )

    override suspend fun execute(params: Params) = repository.fetchProfile(params)
}