package com.arghamnegargroup.core.features.quickitems.domain.model

import com.arghamnegargroup.core.features.department.domain.model.Department
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.SerializedName

data class QuickItems(
    @SerializedName("Departments")
    val departments: List<Department>,
    @SerializedName("Items")
    val items: List<Item>
) {
    fun isEmpty(): Boolean {
        return departments.isEmpty() && items.isEmpty()
    }
}