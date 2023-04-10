package com.arghamnegargroup.core.features.item.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CustomField(
    @SerializedName("CSharpType")
    val cSharpType: String? = null,
    @SerializedName("Caption")
    val caption: String? = null,
    @SerializedName("Direction")
    val direction: String? = null,
    @SerializedName("ID")
    val id: Int? = null,
    @SerializedName("IsIdentity")
    val isIdentity: Boolean? = null,
    @SerializedName("IsNullable")
    val isNullable: Boolean? = null,
    @SerializedName("IsPK")
    val isPK: Boolean? = null,
    @SerializedName("MaxLenght")
    val maxLength: Int? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("Value")
    val value: @RawValue Any? = null,
) : Parcelable
