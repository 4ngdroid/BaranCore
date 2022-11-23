package com.arghamnegargroup.core.features.auth.data.remote.dto.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LoginRequest(
        @SerializedName("userName")
        var username: String,

        @SerializedName("password")
        var password: String? = null,
)