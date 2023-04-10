package com.arghamnegargroup.core.features.auth.domain.usecase

import com.arghamnegargroup.core.features.auth.domain.model.InvalidCredentialsException
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository

class Login(
    private val repository: AuthRepository,
) {
    suspend operator fun invoke(username: String?, password: String?): Result<Unit> {
        if (username.isNullOrBlank()) {
            return Result.failure(NullPointerException("نام کاربری را پر کنید."))
        }

        try {
            val response = repository.login(username, password)
            if (response.user != null) {
                repository.saveUser(user = response.user)
                return Result.success(Unit)
            }
            return Result.failure(InvalidCredentialsException("رمز عبور یا نام کاربری اشتباه است."))
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}