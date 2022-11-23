package com.arghamnegargroup.core.features.table.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.table.domain.model.Table
import com.arghamnegargroup.core.features.table.domain.repository.TableRepository

class TableRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : TableRepository {

    override suspend fun getTables(): List<Table> {
        return api.getTables(connectionRepository.getUrl(Endpoints.GET_TABLES)).tables ?: emptyList()
    }
}