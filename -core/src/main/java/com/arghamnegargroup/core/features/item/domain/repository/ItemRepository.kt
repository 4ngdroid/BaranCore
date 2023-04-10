package com.arghamnegargroup.core.features.item.domain.repository

import com.arghamnegargroup.core.features.item.data.remote.dto.request.ItemInfoRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SaveItemInfoRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SearchRequest
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.model.ItemBarcode
import com.arghamnegargroup.core.features.item.domain.model.ItemsResponse
import retrofit2.http.Url

interface ItemRepository {

    suspend fun getItemInfo(request: ItemInfoRequest): Item?

    suspend fun saveItemInfo(request: SaveItemInfoRequest): Result<Unit>

    suspend fun search(request: SearchRequest): List<Item>

    suspend fun getItemBarcodes(): List<ItemBarcode>

    suspend fun saveItemBarcodes(items: List<ItemBarcode>)

    suspend fun getItemBarcode(barcode: String): ItemBarcode?

    suspend fun deleteItemBarcodes(): Int

    suspend fun getItems(): List<Item>
}