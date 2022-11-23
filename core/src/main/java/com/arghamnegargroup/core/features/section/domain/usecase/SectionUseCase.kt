package com.arghamnegargroup.core.features.section.domain.usecase

data class SectionUseCase(
    val getStockSection: GetStockSection,
    val getStockSections: GetStockSections,
    val itemAssignmentToSection: ItemAssignmentToSection,
)
