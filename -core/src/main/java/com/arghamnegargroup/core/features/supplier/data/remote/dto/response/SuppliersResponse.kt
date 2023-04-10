package com.arghamnegargroup.core.features.supplier.data.remote.dto.response

import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class SuppliersResponse {

    @SerializedName("GetSuppliersResult")
    @Expose
    val result: List<Supplier>? = null

}