package com.jetpack.data.repoimpl


import com.jetpack.apientity.ProfileApiEntity
import com.jetpack.apientity.RepoApiResponseItemEntity
import com.jetpack.data.mapper.ProfileApiMapper
import com.jetpack.data.mapper.RepoApiMapper
import com.jetpack.data.mapper.mapFromApiResponse
import com.jetpack.data.service.RepoApiServices
import com.jetpack.data.wrapper.NetworkBoundResource
import com.jetpack.domain.apiusecase.ProfileApiUseCase
import com.jetpack.domain.apiusecase.RepoListApiUseCase
import com.jetpack.domain.base.ApiResult
import com.jetpack.domain.repository.RepoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepoRepoImpl @Inject constructor(
    private val networkBoundResources: NetworkBoundResource,
    private val repoApiServices: RepoApiServices,
    private val profileApiMapper: ProfileApiMapper,
    private val repoApiMapper: RepoApiMapper,
) : RepoRepository {

    override suspend fun fetchRepoList(params: RepoListApiUseCase.Params): Flow<ApiResult<List<RepoApiResponseItemEntity>>> {
        return mapFromApiResponse(
            networkBoundResources.downloadData {
                repoApiServices.fetchRepoList(params.userName)
            },repoApiMapper
        )
    }

    override suspend fun fetchProfile(params: ProfileApiUseCase.Params): Flow<ApiResult<ProfileApiEntity>> {
        return mapFromApiResponse(
            networkBoundResources.downloadData {
                repoApiServices.fetchProfile(params.userName)
            },profileApiMapper
        )
    }
}