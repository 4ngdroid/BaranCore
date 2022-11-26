package com.arghamnegargroup.core.features.invoice.domain.usecase

import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.ReturnInvoiceRequest
import com.arghamnegargroup.core.features.invoice.domain.repository.InvoiceRepository

class SaveReturnInvoice(
    private val repository: InvoiceRepository,
) {

    suspend operator fun invoke(order: String?, invoiceNumber: String?): Result<Unit> {
        return try {
            repository.saveReturnInvoice(ReturnInvoiceRequest(order, invoiceNumber))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}