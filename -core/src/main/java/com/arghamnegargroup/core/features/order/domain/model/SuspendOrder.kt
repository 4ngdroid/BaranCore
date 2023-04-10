package com.arghamnegargroup.core.features.order.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class SuspendOrder(
    @SerializedName("Order")
    val order: Order?,
    @SerializedName("SitNumber")
    val sitNumber: Int?,
    @SerializedName("SuspendNumber")
    val suspendNumber: String?,
    @SerializedName("TableID")
    val tableID: String?
) : Parcelable