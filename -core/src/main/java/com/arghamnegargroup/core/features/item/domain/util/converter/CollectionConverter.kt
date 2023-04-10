package com.arghamnegargroup.core.features.item.domain.util.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.arghamnegargroup.core.features.item.domain.model.Collection

class CollectionConverter {
    @TypeConverter
    fun fromString(value: String): List<Collection>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<Collection>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<Collection>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}