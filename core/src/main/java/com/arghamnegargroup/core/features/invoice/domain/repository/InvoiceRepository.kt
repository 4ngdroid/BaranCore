package com.arghamnegargroup.core.features.invoice.domain.repository

import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.CalcInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.GetInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.ReturnInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.SaleInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.CalcInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.ReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.SaveReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.SaveSaleInvoiceResponse
import com.arghamnegargroup.core.features.order.domain.model.Order
import retrofit2.http.Body
import retrofit2.http.Url

interface InvoiceRepository {

    suspend fun saveSaleInvoiceByOrder(request: SaleInvoiceRequest): Result<Unit>

    suspend fun calcInvoice(request: CalcInvoiceRequest): Order?

    suspend fun saveReturnInvoice(request: ReturnInvoiceRequest): Result<Unit>

    suspend fun getInvoice(request: GetInvoiceRequest): Order?
}