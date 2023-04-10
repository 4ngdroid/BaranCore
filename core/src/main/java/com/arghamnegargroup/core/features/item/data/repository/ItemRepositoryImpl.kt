package com.arghamnegargroup.core.features.item.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.core.util.ext.isSuccessful
import com.arghamnegargroup.core.features.item.data.remote.dto.request.ItemInfoRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SaveItemInfoRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SearchRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.response.ItemBarcodesResponse
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.model.ItemBarcode
import com.arghamnegargroup.core.features.item.domain.model.ItemsResponse
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.Exception
import java.lang.reflect.Type

class ItemRepositoryImpl(
    private val api: BaranApi,
    private val db: BaranDatabase,
    private val connectionRepository: ConnectionRepository,
) : ItemRepository {

    override suspend fun getItemInfo(request: ItemInfoRequest): Item? {
        val item = api.getItemInfo(connectionRepository.getUrl(Endpoints.GET_ITEM_INFO), request).item
        return if (item.barcode == null)
            null
        else item
    }

    override suspend fun saveItemInfo(request: SaveItemInfoRequest): Result<Unit> {
        val result = api.saveItemInfo(connectionRepository.getUrl(Endpoints.SAVE_ITEM_INFO), request).result
        return if (result.isSuccessful) Result.success(Unit)
        else Result.failure(Exception(result.message))
    }

    override suspend fun search(request: SearchRequest): List<Item> {
        return api.searchItem(connectionRepository.getUrl(Endpoints.SEARCH_ITEM), request).result
    }

    override suspend fun getItemBarcodes(): List<ItemBarcode> {
        val response = api.getItemBarcodes(connectionRepository.getUrl(Endpoints.GET_ITEM_BARCODES))
        val type: Type = object : TypeToken<ItemBarcodesResponse?>() {}.type
        val result = Gson().fromJson<ItemBarcodesResponse?>(response.body()!!.string(), type)
        return result.barcodes ?: emptyList()
    }

    override suspend fun saveItemBarcodes(items: List<ItemBarcode>) {
        db.itemBarcodeDao().deleteItemBarcodes()
        return db.itemBarcodeDao().saveItemBarcodes(items)
    }

    override suspend fun getItemBarcode(barcode: String): Item {
        val item = db.itemBarcodeDao().getItemBarcode(barcode)
        return if (item != null) {
            Item(
                barcode = item.barcode,
                itemId = item.barcode ?: "",
                name = item.name ?: item.barcode,
            )
        } else {
            Item(
                barcode = barcode,
                itemId = barcode,
                name = barcode,
            )
        }

    }

    override suspend fun deleteItemBarcodes(): Int {
        return db.itemBarcodeDao().deleteItemBarcodes()
    }

    override suspend fun getItems(): List<Item> {
        return api.getItems(connectionRepository.getUrl(Endpoints.GET_ITEMS)).items
    }
}