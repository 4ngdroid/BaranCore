package com.arghamnegargroup.core.features.table.domain.repository

import com.arghamnegargroup.core.features.table.domain.model.Table

interface TableRepository {

    suspend fun getTables(): List<Table>
}