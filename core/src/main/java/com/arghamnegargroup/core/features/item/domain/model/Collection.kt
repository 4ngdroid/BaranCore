package com.arghamnegargroup.core.features.item.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Collection(
    @SerializedName("Barcode")
    val barcode: String? = null,
    @SerializedName("ChildItemID")
    val childItemId: String? = null,
    @SerializedName("DefaultValue")
    val defaultValue: Double? = null,
    @SerializedName("ItemID")
    val itemID: String? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("Quantity")
    val quantity: Double? = null,
) : Parcelable