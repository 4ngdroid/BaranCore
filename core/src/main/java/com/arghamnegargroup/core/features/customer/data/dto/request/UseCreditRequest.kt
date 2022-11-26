package com.arghamnegargroup.core.features.customer.data.dto.request

data class UseCreditRequest(
    val customerId: String,
    val amount: Double,
    val groupId: String? = null,
    val point: Double? = null,
    val description: String? = null,
    val storeId: Int? = null,
    val workStationId: Int? = null,
    val invoiceId: String? = null
)