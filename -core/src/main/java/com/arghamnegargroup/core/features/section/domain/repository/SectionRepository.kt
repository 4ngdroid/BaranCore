package com.arghamnegargroup.core.features.section.domain.repository

import com.arghamnegargroup.core.features.section.data.remote.request.ItemAssignmentRequest
import com.arghamnegargroup.core.features.section.data.remote.request.StockSectionRequest
import com.arghamnegargroup.core.features.section.domain.model.Section


interface SectionRepository {

    suspend fun getStockSection(request: StockSectionRequest): Section?

    suspend fun getStockSections():  List<Section>

    suspend fun itemAssignmentToSection(request: ItemAssignmentRequest): Result<Unit>
}