package com.arghamnegargroup.core.features.section.domain.model

import com.google.gson.annotations.SerializedName

data class ItemStockSection(
    @Transient
    val name: String? = null,

    @Transient
    val barcode: String? = null,

    @Transient
    val type: Type? = Type.ADD,

    @Transient
    val sourceSection: String? = null,

    @Transient
    val targetSection: String? = null,

    @Transient
    val sourceSectionName: String? = null,

    @Transient
    val targetSectionName: String? = null,

    @Transient
    val _stockSections: String? = null,

    @SerializedName("ItemID")
    val itemId: String? = null,

    @SerializedName("Remove")
    var remove: Boolean? = false,

    @SerializedName("SectionID")
    var sectionId: String? = null
) {
    val stockSections: () -> String?
        get() = {
            val sections = _stockSections?.split(";")
            val pre = "قفسه قبلی: "
            var out = ""
            if (sections?.isNotEmpty() == true) {
                out = sections.slice(0 until sections.size - 1).joinToString(separator = ", ")
            }
            if (out.isEmpty()) null else "$pre$out"
        }
}

enum class Type {
    ADD, DELETE, MOVE
}