package com.arghamnegargroup.core.features.core.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.google.gson.Gson

class StringConverter {
    @TypeConverter
    fun fromString(value: String): List<String>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<String>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<String>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}