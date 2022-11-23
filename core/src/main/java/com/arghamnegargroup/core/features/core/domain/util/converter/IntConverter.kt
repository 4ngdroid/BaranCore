package com.arghamnegargroup.core.features.core.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.google.gson.Gson

class IntConverter {
    @TypeConverter
    fun fromString(value: String): List<Int>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<Int>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<Int>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}