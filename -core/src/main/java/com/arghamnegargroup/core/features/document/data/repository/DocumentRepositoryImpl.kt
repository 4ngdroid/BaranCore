package com.arghamnegargroup.core.features.document.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.core.util.ext.isSuccessful
import com.arghamnegargroup.core.features.document.data.remote.dto.request.BookStockDocumentRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.request.DocumentInfoRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.request.SaveBarcodeFileRequest
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.model.Status
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.arghamnegargroup.core.features.thirdparty.domain.model.ThirdParty
import java.lang.Exception

class DocumentRepositoryImpl(
    private val api: BaranApi,
    private val db: BaranDatabase,
    private val connectionRepository: ConnectionRepository,
) : DocumentRepository {

    override suspend fun bookDocument(request: BookStockDocumentRequest): Result<Unit> {
        val response = api.bookStockDocument(connectionRepository.getUrl(Endpoints.BOOK_STOCK_DOCUMENT), request)
        if (!response.result.isSuccessful) {
            return Result.failure(Exception(response.result.message))
        }
        return Result.success(Unit)
    }

    override suspend fun getDocumentInfo(request: DocumentInfoRequest): Document? {
        return api.getDocumentInfo(connectionRepository.getUrl(Endpoints.GET_DOCUMENT_INFO), request).document
    }

    override suspend fun saveBarcodeFile(request: SaveBarcodeFileRequest): Result<Unit> {
        val response = api.saveBarcodeFile(connectionRepository.getUrl(Endpoints.SAVE_BARCODE_FILE), request)
        return if (response.isSuccessful) {
            Result.success(Unit)
        } else Result.failure(Exception("سند ذخیره نشد."))
    }

    override suspend fun saveDocument(document: Document) {
        return db.documentDao().saveDocument(document)
    }

    override suspend fun setSourceStock(id: Int, sourceStock: Stock?) {
        return db.documentDao().setSourceStock(id, sourceStock?.id, sourceStock?.name)
    }

    override suspend fun setTargetStock(id: Int, targetStock: Stock?) {
        return db.documentDao().setTargetStock(id, targetStock?.id, targetStock?.name)
    }

    override suspend fun setThirdParty(id: Int, thirdParty: ThirdParty?) {
        return db.documentDao().setThirdParty(id, thirdParty?.id, thirdParty?.name)
    }

    override suspend fun setSupplier(id: Int, supplier: Supplier?) {
        return db.documentDao().setSupplier(id, supplier?.id, supplier?.name)
    }

    override suspend fun setItems(id: Int, items: List<Item>) {
        return db.documentDao().setItems(id, items)
    }

    override suspend fun deleteDocument(id: Int) {
        return db.documentDao().deleteDocument(id)
    }

    override suspend fun setStatus(id: Int, status: Status) {
        return db.documentDao().setStatus(id, status)
    }

    override suspend fun getLastDocument(): Document? {
        return db.documentDao().getLastDocument()
    }
}