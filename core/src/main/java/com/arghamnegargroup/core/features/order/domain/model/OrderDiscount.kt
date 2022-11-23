package com.arghamnegargroup.core.features.order.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class OrderDiscount(
    @SerializedName("AllowMerge")
    var allowMerge: Boolean = false,
    @SerializedName("DiscountAmount")
    val discountAmount: Double = 0.0,
    @SerializedName("DiscountPercent")
    val discountPercent: Double = 0.0,
    @SerializedName("ReasonID")
    val reasonId: Int,
    @Transient val reason: String?
) : Parcelable
