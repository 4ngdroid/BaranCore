package com.arghamnegargroup.core.features.quickitems.domain.repository

import com.arghamnegargroup.core.features.quickitems.domain.model.QuickItems

interface QuickItemsRepository {

    suspend fun getQuickItemsRemote(): QuickItems

    suspend fun getQuickItemsLocal(): QuickItems

    suspend fun saveQuickItems(quickItems: QuickItems)
}