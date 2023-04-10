package com.arghamnegargroup.core.features.reason.domain.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Reason(
    @PrimaryKey(autoGenerate = false)
    @SerializedName("ID")
    val id: String,
    @SerializedName("Name")
    val name: String?
)