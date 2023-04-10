package com.arghamnegargroup.core.features.auth.data.remote.dto.response

import com.arghamnegargroup.core.features.auth.domain.model.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("GetUserResult")
        val user: User?
)