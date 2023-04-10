package com.arghamnegargroup.core.features.section.domain.model

import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("Name")
    val name: String? = null,

    @SerializedName("SectionID")
    val sectionId: String? = null,

    @SerializedName("StockID")
    val stockId: String? = null
)