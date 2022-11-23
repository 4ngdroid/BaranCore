package com.arghamnegargroup.core.features.dictionary.data.remote.request

import com.google.gson.annotations.SerializedName

data class DictionaryRequest(
    @SerializedName("type")
    val type: Int
)