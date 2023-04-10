package com.arghamnegargroup.core.features.auth.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.auth.domain.model.Permission
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.google.gson.Gson

class PermissionConverter {

    @TypeConverter
    fun fromString(value: String): List<Permission>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<Permission>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<Permission>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}