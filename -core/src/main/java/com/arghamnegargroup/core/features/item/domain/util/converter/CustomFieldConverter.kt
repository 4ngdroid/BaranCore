package com.arghamnegargroup.core.features.item.domain.util.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.arghamnegargroup.core.features.item.domain.model.Collection
import com.arghamnegargroup.core.features.item.domain.model.CustomField

class CustomFieldConverter {
    @TypeConverter
    fun fromString(value: String): List<CustomField>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<CustomField>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<CustomField>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}