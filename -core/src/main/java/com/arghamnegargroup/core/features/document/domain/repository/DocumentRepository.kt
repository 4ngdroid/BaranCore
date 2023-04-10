package com.arghamnegargroup.core.features.document.domain.repository

import androidx.room.Query
import com.arghamnegargroup.core.features.document.data.remote.dto.request.BookStockDocumentRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.request.DocumentInfoRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.request.SaveBarcodeFileRequest
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.model.Status
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.arghamnegargroup.core.features.thirdparty.domain.model.ThirdParty

interface DocumentRepository {

    suspend fun bookDocument(request: BookStockDocumentRequest): Result<Unit>

    suspend fun getDocumentInfo(request: DocumentInfoRequest): Document?

    suspend fun saveBarcodeFile(request: SaveBarcodeFileRequest): Result<Unit>

    suspend fun saveDocument(document: Document)

    suspend fun setSourceStock(id: Int, sourceStock: Stock?)

    suspend fun setTargetStock(id: Int, targetStock: Stock?)

    suspend fun setThirdParty(id: Int, thirdParty: ThirdParty?)

    suspend fun setSupplier(id: Int, supplier: Supplier?)

    suspend fun setItems(id: Int, items: List<Item>)

    suspend fun deleteDocument(id: Int)

    suspend fun setStatus(id: Int, status: Status)

    suspend fun getLastDocument(): Document?
}