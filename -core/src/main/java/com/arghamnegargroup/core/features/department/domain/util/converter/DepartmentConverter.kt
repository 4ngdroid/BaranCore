package com.arghamnegargroup.core.features.department.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.google.gson.Gson

class DepartmentConverter {
    @TypeConverter
    fun fromString(value: String): List<Department>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<Department>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<Department>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}