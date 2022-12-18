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

    override suspend fun getQuickItemsRemote(): QuickItems {
        return api.getQuickItems(connectionRepository.getUrl(Endpoints.GET_QUICK_ITEMS)).quickItems
    }

    override suspend fun getQuickItemsLocal(): QuickItems {
        val departments = db.departmentDao().getDepartments()
        val items = db.itemDao().getItems()
        return QuickItems(departments, items)
    }

    override suspend fun saveQuickItems(quickItems: QuickItems) {
        db.departmentDao().deleteDepartments()
        db.departmentDao().saveDepartments(quickItems.departments)
        db.itemDao().deleteItems()
        db.itemDao().saveItems(quickItems.items)
    }
}