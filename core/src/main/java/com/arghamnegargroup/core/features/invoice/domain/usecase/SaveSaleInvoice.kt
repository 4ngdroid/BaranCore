package com.arghamnegargroup.core.features.invoice.domain.usecase

import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.SaleInvoiceRequest
import com.arghamnegargroup.core.features.invoice.domain.repository.InvoiceRepository
import com.arghamnegargroup.core.features.order.domain.model.Order
import com.google.gson.annotations.SerializedName

class SaveSaleInvoice(
    private val repository: InvoiceRepository,
) {

    suspend operator fun invoke(
        order: Order?,
        calcPromotion: Boolean?,
        calcTax: Boolean?,
        allowToMakeInvoice: Boolean?,
        useCredit: Boolean = true,
    ): Result<Unit> {
        return try {
            repository.saveSaleInvoiceByOrder(SaleInvoiceRequest(
                order, calcPromotion, calcTax, allowToMakeInvoice, useCredit
            ))
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}