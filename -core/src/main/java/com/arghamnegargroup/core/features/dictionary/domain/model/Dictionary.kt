package com.arghamnegargroup.core.features.dictionary.domain.model


import com.google.gson.annotations.SerializedName

data class Dictionary(
    @SerializedName("Email")
    val email: String?,
    @SerializedName("ID")
    val iD: String?,
    @SerializedName("Image")
    val image: String?,
    @SerializedName("Key")
    val key: String?,
    @SerializedName("Name")
    val name: String?
) {
    sealed class Type(val code: Int) {
        object Product : Type(2)
        object MeasureUnit : Type(5)
    }
}