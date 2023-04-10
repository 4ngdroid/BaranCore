package com.arghamnegargroup.core.features.store.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class Store(
    @SerializedName("Address")
    var address: String? = null,

    @SerializedName("Fax")
    var fax: String? = null,

    @SerializedName("Latitude")
    val latitude: Double? = null,

    @SerializedName("Longitude")
    var longitude: Double? = null,

    @PrimaryKey
    @SerializedName("StoreID")
    var id: Int? = null,

    @SerializedName("StoreName")
    var name: String? = null,

    @SerializedName("Telephone")
    var telephone: String? = null,
)