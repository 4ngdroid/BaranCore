package com.arghamnegargroup.core.features.auth.domain.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
data class User(
    @SerializedName("Departments")
    var departments: List<Department>? = null,

    @SerializedName("DisplayName")
    var displayName: String? = null,

    @SerializedName("EmployeeID")
    var employeeID: String? = null,

    @Ignore
    @SerializedName("Permissions")
    var permissions: List<Permission>? = null,

    var selectedPermission: List<Int>? = null,

    @PrimaryKey(autoGenerate = false)
    @SerializedName("UserID")
    var  userID: String
) {
    constructor() : this(departments = null, displayName = null, employeeID = null, permissions = null, selectedPermission = null, userID = "")
}