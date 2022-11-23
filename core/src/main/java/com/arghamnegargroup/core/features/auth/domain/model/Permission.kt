package com.arghamnegargroup.core.features.auth.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "permission")
data class Permission(
        @SerializedName("AccessFlag")
        val accessFlag: Boolean,

        @PrimaryKey(autoGenerate = false)
        @SerializedName("PermissionID")
        val permissionID: Int,

        @SerializedName("PermissionName")
        val permissionName: String?
)