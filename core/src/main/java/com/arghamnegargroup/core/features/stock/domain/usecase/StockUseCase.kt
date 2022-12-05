package com.arghamnegargroup.core.features.stock.domain.usecase

data class StockUseCase(
    val getStocks: GetStocks,
    val getStock: GetStock,
    val saveStock: SaveStock,
    val removeStock: RemoveStock,
)
