package com.arghamnegargroup.core.features.auth.domain.usecase

import android.content.Context
import android.content.Intent
import android.util.Log
import com.arghamnegargroup.core.features.auth.domain.model.InvalidCredentialsException
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository
import com.arghamnegargroup.core.features.auth.domain.util.ext.applyPermissions
import com.arghamnegargroup.core.features.core.util.common.CoreConstants
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.licence.domain.usecase.ValidateLicense
import com.arghamnegargroup.core.features.licence.presentation.LicenseActivity

class Login(
    private val context: Context,
    private val repository: AuthRepository,
    private val validateLicense: ValidateLicense
) {
    suspend operator fun invoke(username: String?, password: String?): Result<Unit> {
        if (username.isNullOrBlank()) {
            return Result.failure(NullPointerException("نام کاربری را پر کنید."))
        }

        try {
            val response = repository.login(username, password)
            if (response.user != null) {
                try {
                    val valid = validateLicense()
                    if (valid == false) {
                        val intent = Intent(context, LicenseActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                        context.startActivity(intent)
                        return Result.failure(Exception("تعداد کاربران وارد شده بیش از حد مجاز میباشد."))
                    }
                } catch (_: Throwable) {
                }
                response.user.applyPermissions()
                repository.saveUser(user = response.user)
                repository.setUserId(response.user.userID)
                repository.setLastUsername(username)
                return Result.success(Unit)
            }
            return Result.failure(InvalidCredentialsException("رمز عبور یا نام کاربری اشتباه است."))
        } catch (e: Throwable) {
            return Result.failure(Exception("لطفا اتصال شبکه را بررسی بفرمایید."))
        }
    }
}