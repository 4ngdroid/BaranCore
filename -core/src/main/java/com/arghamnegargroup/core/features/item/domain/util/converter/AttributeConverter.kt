package com.arghamnegargroup.core.features.item.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.arghamnegargroup.core.features.item.domain.model.Attribute
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.Gson

class AttributeConverter {
    @TypeConverter
    fun fromString(value: String): List<Attribute>? {
        if (value.isBlank()) {
            return emptyList()
        }
        return Gson().fromJson(value, Array<Attribute>::class.java).toList()
    }

    @TypeConverter
    fun toString(value: List<Attribute>?): String {
        if (value == null) {
            return ""
        }
        return Gson().toJson(value)
    }
}