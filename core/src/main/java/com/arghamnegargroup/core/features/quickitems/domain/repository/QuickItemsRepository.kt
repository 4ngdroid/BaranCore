package com.arghamnegargroup.core.features.quickitems.domain.repository

import com.arghamnegargroup.core.features.quickitems.domain.model.QuickItems

interface QuickItemsRepository {

    suspend fun getQuickItems(): QuickItems
}