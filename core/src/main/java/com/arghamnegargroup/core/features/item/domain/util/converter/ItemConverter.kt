package com.arghamnegargroup.core.features.item.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.Gson

class ItemConverter {
    @TypeConverter
    fun fromString(value: String): List<Item>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<Item>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<Item>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}