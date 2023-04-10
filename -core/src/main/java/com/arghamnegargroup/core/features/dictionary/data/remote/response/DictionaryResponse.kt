package com.arghamnegargroup.core.features.dictionary.data.remote.response


import com.arghamnegargroup.core.features.dictionary.domain.model.Dictionary
import com.google.gson.annotations.SerializedName

data class DictionaryResponse(
    @SerializedName("GetDictionaryResult")
    val result: List<Dictionary>?
)