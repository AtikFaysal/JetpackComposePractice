package com.jetpack.data.mapper

import com.jetpack.api_response.RepoApiResponseItem
import com.jetpack.apientity.LicenseEntity
import com.jetpack.apientity.OwnerEntity
import com.jetpack.apientity.RepoApiResponseItemEntity
import javax.inject.Inject

class RepoApiMapper @Inject constructor(): Mapper<List<RepoApiResponseItem>, List<RepoApiResponseItemEntity>> {
    override fun mapFromApiResponse(type: List<RepoApiResponseItem>): List<RepoApiResponseItemEntity> {
        return type.map {
            RepoApiResponseItemEntity(
                full_name = it.full_name ?: "",
                description = it.description ?: "",
                id = it.id ?: -1,
                name = it.name ?: "",
                url = it.url ?: "",
                owner = OwnerEntity(
                    avatar_url = it.owner?.avatar_url ?: ""
                ),
                license = LicenseEntity(
                    key = it.license?.key ?: "",
                    name = it.license?.name ?: "",
                    url = it.license?.url ?: "",
                )
            )
        }
    }
}