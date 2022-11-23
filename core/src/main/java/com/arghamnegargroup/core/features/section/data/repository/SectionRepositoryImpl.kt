package com.arghamnegargroup.core.features.section.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.core.util.ext.isSuccessfull
import com.arghamnegargroup.core.features.section.data.remote.request.ItemAssignmentRequest
import com.arghamnegargroup.core.features.section.data.remote.request.StockSectionRequest
import com.arghamnegargroup.core.features.section.domain.model.Section
import com.arghamnegargroup.core.features.section.domain.repository.SectionRepository
import java.lang.Exception

class SectionRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : SectionRepository {

    override suspend fun getStockSection(request: StockSectionRequest): Section? {
        return api.getStockSection(connectionRepository.getUrl(Endpoints.GET_STOCK_SECTION), request).section
    }

    override suspend fun getStockSections(): List<Section> {
        return api.getStockSections(connectionRepository.getUrl(Endpoints.GET_STOCK_SECTIONS)).sections
    }

    override suspend fun itemAssignmentToSection(request: ItemAssignmentRequest): Result<Unit> {
        val result = api.itemAssignmentToSection(connectionRepository.getUrl(Endpoints.ITEM_ASSIGNMENT_TO_SECTION),
            request).result
        return if (result.isSuccessfull)
            Result.success(Unit)
        else Result.failure(Exception(result.message))
    }
}