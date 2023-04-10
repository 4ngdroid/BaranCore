package com.arghamnegargroup.core.features.stock.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Stock(
    @PrimaryKey
    @SerializedName("StockID")
    val id: String,

    @SerializedName("StockName")
    val name: String?
) : Parcelable