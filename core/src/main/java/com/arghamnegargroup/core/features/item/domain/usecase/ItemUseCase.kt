package com.arghamnegargroup.core.features.item.domain.usecase

data class ItemUseCase(
    val getItemInfo: GetItemInfo,
    val saveItemInfo: SaveItemInfo,
    val search: Search,
    val getItemBarcode: GetItemBarcode,
    val saveItemBarcodes: SaveItemBarcodes,
)