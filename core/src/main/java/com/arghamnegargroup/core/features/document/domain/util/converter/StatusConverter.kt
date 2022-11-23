package com.arghamnegargroup.core.features.document.domain.util.converter

import androidx.room.TypeConverter
import com.arghamnegargroup.core.features.document.domain.model.Status

class StatusConverter {
    @TypeConverter
    fun toStatus(value: String) = enumValueOf<Status>(value)

    @TypeConverter
    fun fromStatus(value: Status) = value.name
}