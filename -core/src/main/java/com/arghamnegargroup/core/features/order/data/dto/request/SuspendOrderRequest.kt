package com.arghamnegargroup.core.features.order.data.dto.request

import android.os.Parcelable
import com.arghamnegargroup.core.features.order.domain.model.Order
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SuspendOrderRequest(
    @SerializedName("order")
    val order: Order?,
    @SerializedName("sitNumber")
    val sitNumber: String?,
    @SerializedName("number")
    val suspendNumber: String?,
    @SerializedName("TableID")
    val tableID: String?,
    @SerializedName("allowPrint")
    val allowPrint: Boolean
) : Parcelable