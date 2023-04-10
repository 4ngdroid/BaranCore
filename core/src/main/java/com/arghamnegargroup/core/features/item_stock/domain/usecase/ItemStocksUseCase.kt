package com.arghamnegargroup.core.features.item_stock.domain.usecase

data class ItemStocksUseCase(
    val getItemStocks: GetItemStocks,
    val changeItemStocks: ChangeItemStocks,
)