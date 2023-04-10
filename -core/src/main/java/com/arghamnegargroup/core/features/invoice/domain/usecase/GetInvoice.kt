package com.arghamnegargroup.core.features.invoice.domain.usecase

import com.arghamnegargroup.core.features.auth.data.repository.AuthRepositoryImpl
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.GetInvoiceRequest
import com.arghamnegargroup.core.features.invoice.domain.repository.InvoiceRepository
import com.arghamnegargroup.core.features.order.domain.model.Order

class GetInvoice(
    private val repository: InvoiceRepository,
) {

    suspend operator fun invoke(invoiceNumber: String?): Result<Order?> {
        return try {
            if (invoiceNumber == null)
                throw NullPointerException("شماره فاکتور خالی است.")
            Result.success(repository.getInvoice(GetInvoiceRequest(invoiceNumber)))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}