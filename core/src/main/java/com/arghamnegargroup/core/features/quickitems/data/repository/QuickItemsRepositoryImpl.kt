package com.arghamnegargroup.core.features.quickitems.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.quickitems.domain.model.QuickItems
import com.arghamnegargroup.core.features.quickitems.domain.repository.QuickItemsRepository

class QuickItemsRepositoryImpl(
    private val db: BaranDatabase,
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : QuickItemsRepository {

    override suspend fun getQuickItems(): QuickItems {
        return api.getQuickItems(connectionRepository.getUrl(Endpoints.GET_QUICK_ITEMS)).quickItems
    }
}