package com.arghamnegargroup.core.features.auth.domain.usecase

data class AuthUseCase(
    val login: Login,
    val getUser: GetUser,
)
