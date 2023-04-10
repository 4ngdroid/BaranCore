package com.arghamnegargroup.core.features.item.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ItemBarcode(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @SerializedName("Name")
    val name: String? = null,

    @SerializedName("Barcode")
    val barcode: String? = null
)
