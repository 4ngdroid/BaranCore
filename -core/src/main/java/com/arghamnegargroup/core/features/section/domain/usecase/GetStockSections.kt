package com.arghamnegargroup.core.features.section.domain.usecase

import com.arghamnegargroup.core.features.section.domain.model.Section
import com.arghamnegargroup.core.features.section.domain.repository.SectionRepository

class GetStockSections(
    private val sectionRepository: SectionRepository,
) {

    suspend operator fun invoke(): Result<List<Section>> {
        return try {
            Result.success(sectionRepository.getStockSections())
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}