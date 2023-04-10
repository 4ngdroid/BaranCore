package com.arghamnegargroup.core.features.department.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Department(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long? = null,
    @SerializedName(value = "DepartmentID", alternate = ["ID"])
    val departmentID: String? = null,
    @SerializedName("DepartmentName", alternate = ["Name"])
    val departmentName: String? = null,
    @SerializedName("DepartmentKey", alternate = ["Key"])
    val key: String? = null,
)