package com.arghamnegargroup.core.features.supplier.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Supplier(
        @PrimaryKey
        @SerializedName("ID")
        val id: String,

        @SerializedName("Key")
        val key: String? = null,

        @SerializedName("Name")
        val name: String?
) : Parcelable