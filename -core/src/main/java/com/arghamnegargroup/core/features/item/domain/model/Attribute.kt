package com.arghamnegargroup.core.features.item.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attribute(
    @SerializedName("Attribute")
    val attribute: String? = null,
    @SerializedName("Code")
    val code: String? = null,
    @SerializedName("ItemID")
    val itemId: String? = null,
    @SerializedName("Value")
    val value: String? = null,
) : Parcelable
