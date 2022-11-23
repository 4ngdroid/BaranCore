package com.arghamnegargroup.core.features.store.data.remote.dto.response

import com.arghamnegargroup.core.features.store.domain.model.Store
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class StoreResponse(
        @SerializedName("GetStoresResult")
        var result: List<Store>? = null
)