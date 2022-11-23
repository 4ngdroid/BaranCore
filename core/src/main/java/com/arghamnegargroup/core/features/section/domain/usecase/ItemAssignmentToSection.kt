package com.arghamnegargroup.core.features.section.domain.usecase

import com.arghamnegargroup.core.features.section.data.remote.request.ItemAssignmentRequest
import com.arghamnegargroup.core.features.section.domain.model.ItemStockSection
import com.arghamnegargroup.core.features.section.domain.repository.SectionRepository

class ItemAssignmentToSection(
    private val sectionRepository: SectionRepository,
) {

    suspend operator fun invoke(items: List<ItemStockSection>): Result<Unit> {
        return try {
            sectionRepository.itemAssignmentToSection(ItemAssignmentRequest(items))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}