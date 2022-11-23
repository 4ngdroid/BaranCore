package com.arghamnegargroup.core.features.order.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Detail (
    @SerializedName("DetailID")
    val detailId: Int? = null,
    @SerializedName("ItemID")
    val itemId: String? = null,
    @SerializedName("Price")
    val price: Double? = null,
    @SerializedName("Quantity")
    val quantity: Double? = null
) : Parcelable