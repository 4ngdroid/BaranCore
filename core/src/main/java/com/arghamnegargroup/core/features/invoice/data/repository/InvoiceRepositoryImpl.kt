package com.arghamnegargroup.core.features.invoice.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.core.util.ext.isSuccessful
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.CalcInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.GetInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.ReturnInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.SaleInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.ReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.domain.repository.InvoiceRepository
import com.arghamnegargroup.core.features.order.domain.model.Order

class InvoiceRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : InvoiceRepository {

    override suspend fun saveSaleInvoiceByOrder(request: SaleInvoiceRequest): Result<Unit> {
        val response = api.saveSaleInvoiceByOrder(connectionRepository.getUrl(Endpoints.SAVE_SALE_INVOICE), request)
        return if (response.general.isSuccessful)
            Result.success(Unit)
        else Result.failure(Exception(response.general?.message))
    }

    override suspend fun calcInvoice(request: CalcInvoiceRequest): Order? {
        return api.calcInvoice(connectionRepository.getUrl(Endpoints.CALC_INVOICE), request).getOrder()
    }

    override suspend fun saveReturnInvoice(request: ReturnInvoiceRequest): Result<Unit> {
        val response = api.saveReturnInvoice(connectionRepository.getUrl(Endpoints.SAVE_RETURN_INVOICE), request)
        return if (response.general.isSuccessful)
            Result.success(Unit)
        else Result.failure(Exception(response.general?.message))
    }

    override suspend fun getInvoice(request: GetInvoiceRequest): Order? {
        return api.getInvoice(connectionRepository.getUrl(Endpoints.GET_INVOICE_BY_INVOICE_NUMBER), request).getOrder()
    }


}