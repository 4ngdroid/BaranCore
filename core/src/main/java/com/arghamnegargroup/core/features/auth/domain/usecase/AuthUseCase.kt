package com.arghamnegargroup.core.features.auth.domain.usecase


data class AuthUseCase(
    val login: Login,
    val logout: Logout,
    val getUser: GetUser,
    val getUserId: GetUserId,
    val getLastUsername: GetLastUsername,
)
