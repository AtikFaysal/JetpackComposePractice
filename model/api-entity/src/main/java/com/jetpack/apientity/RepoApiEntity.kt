package com.jetpack.apientity

data class RepoApiResponseItemEntity(
    val description: String,
    val full_name: String,
    val id: Int,
    val name: String,
    val url: String,
    val owner: OwnerEntity,
    val license: LicenseEntity,
)

data class OwnerEntity(
    val avatar_url: String,
)

data class LicenseEntity(
    val key: String,
    val name: String,
    val url: String
)