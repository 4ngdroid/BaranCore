package com.arghamnegargroup.core.features.table.data.dto.response

import com.arghamnegargroup.core.features.table.domain.model.Table
import com.google.gson.annotations.SerializedName

data class TableResponse(
    @SerializedName("GetTablesResult")
    val tables: List<Table>?
)