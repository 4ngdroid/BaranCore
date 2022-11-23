package com.arghamnegargroup.core.features.invoice.domain.repository

import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.CalcInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.ReturnInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.SaleInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.CalcInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.ReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.SaveReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.SaveSaleInvoiceResponse

interface InvoiceRepository {

    suspend fun saveSaleInvoiceByOrder(request: SaleInvoiceRequest): SaveSaleInvoiceResponse

    suspend fun calcInvoice(request: CalcInvoiceRequest): CalcInvoiceResponse

    suspend fun getInvoice(request: ReturnInvoiceRequest): ReturnInvoiceResponse

    suspend fun saveReturnInvoice(request: ReturnInvoiceRequest): SaveReturnInvoiceResponse

}