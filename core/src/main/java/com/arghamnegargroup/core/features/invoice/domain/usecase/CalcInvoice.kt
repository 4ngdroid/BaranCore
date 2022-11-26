package com.arghamnegargroup.core.features.invoice.domain.usecase

import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.CalcInvoiceRequest
import com.arghamnegargroup.core.features.invoice.domain.repository.InvoiceRepository
import com.arghamnegargroup.core.features.order.domain.model.Order

class CalcInvoice(
    private val repository: InvoiceRepository,
) {

    suspend operator fun invoke(
        order: String?,
        calcPromotion: Boolean?,
        calcTax: Boolean?,
    ): Result<Order?> {
        return try {
            Result.success(repository.calcInvoice(CalcInvoiceRequest(order, calcPromotion, calcTax)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}