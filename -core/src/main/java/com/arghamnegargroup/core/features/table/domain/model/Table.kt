package com.arghamnegargroup.core.features.table.domain.model

import com.google.gson.annotations.SerializedName

data class Table(
    @SerializedName("Capacity")
    val capacity: Int,
    @SerializedName("Description")
    val description: String?,
    @SerializedName("ID")
    val iD: String,
    @SerializedName("TableNo")
    val tableNo: Int,
    var busy: Boolean = false,
    var waitTime: Int = 0
)