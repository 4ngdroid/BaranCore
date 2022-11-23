package com.arghamnegargroup.core.features.table.domain.usecase

import com.arghamnegargroup.core.features.table.domain.model.Table
import com.arghamnegargroup.core.features.table.domain.repository.TableRepository

class GetTables(
    private val repository: TableRepository,
) {

    suspend operator fun invoke(): Result<List<Table>> {
        return try {
            Result.success(repository.getTables())
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}