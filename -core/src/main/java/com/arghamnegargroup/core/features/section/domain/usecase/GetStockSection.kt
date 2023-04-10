package com.arghamnegargroup.core.features.section.domain.usecase

import com.arghamnegargroup.core.features.section.data.remote.request.StockSectionRequest
import com.arghamnegargroup.core.features.section.domain.model.Section
import com.arghamnegargroup.core.features.section.domain.repository.SectionRepository
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository

class GetStockSection(
    private val sectionRepository: SectionRepository,
    private val stockRepository: StockRepository,
) {

    suspend operator fun invoke(code: String?): Result<Section?> {
        try {
            if (code == null)
                return Result.failure(NullPointerException("کد قفسه را پر کنید."))
            return Result.success(
                sectionRepository.getStockSection(StockSectionRequest(code,
                    stockRepository.getCurrentStock()?.id)))
        } catch (e: Throwable) {
            return Result.failure(e)
        }
    }
}