package com.jetpack.data.mapper

import com.jetpack.api_response.ProfileApiResponse
import com.jetpack.apientity.ProfileApiEntity
import timber.log.Timber
import javax.inject.Inject

class ProfileApiMapper @Inject constructor(): Mapper<ProfileApiResponse, ProfileApiEntity> {
    override fun mapFromApiResponse(type: ProfileApiResponse): ProfileApiEntity {
        return ProfileApiEntity(
            documentationUrl = type.documentation_url ?: "",
            message = type.message ?: ""
        )
    }
}