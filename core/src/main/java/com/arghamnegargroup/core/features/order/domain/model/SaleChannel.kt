package com.arghamnegargroup.core.features.order.domain.model

enum class SaleChannel(val value: Int, val displayName: String) {
    Retail(16, "خرده فروشی"),
    Wholesale(17, "عمده فروشی"),
    Online(18, "فروش آنلاین");

    companion object {
        fun fromInt(value: Int) = SaleChannel.values().find { it.value == value }
    }
}