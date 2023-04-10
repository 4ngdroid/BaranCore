package com.arghamnegargroup.core.features.order.data.dto.response


import com.arghamnegargroup.core.features.order.domain.model.SuspendOrder
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class SuspendOrdersResponse(
    @SerializedName("GetSuspendOrdersResult")
    var result: String?
){
    fun getSuspendOrders(): List<SuspendOrder>? {
        val type = object : TypeToken<List<SuspendOrder>>() {}.type
        return Gson().fromJson<List<SuspendOrder>>(this.result, type)
    }
}