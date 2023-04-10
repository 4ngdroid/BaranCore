package com.arghamnegargroup.core.features.invoice.domain.usecase

data class InvoiceUseCase(
    val saveSaleInvoice: SaveSaleInvoice,
    val calcInvoice: CalcInvoice,
    val saveReturnInvoice: SaveReturnInvoice,
    val getInvoice: GetInvoice,
)