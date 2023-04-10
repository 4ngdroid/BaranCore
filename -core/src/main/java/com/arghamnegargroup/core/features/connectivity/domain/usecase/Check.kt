package com.arghamnegargroup.core.features.connectivity.domain.usecase

import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository
import com.arghamnegargroup.core.features.supplier.domain.repository.SupplierRepository

class Check(
    private val stockRepository: StockRepository,
    private val storeRepository: StoreRepository,
    private val supplierRepository: SupplierRepository,
) {

    suspend operator fun invoke(): Result<Unit> {
        return try {
            val stocks = stockRepository.getStocksRemote()
            val stores = storeRepository.getStoresRemote()
            val suppliers = supplierRepository.getSuppliersRemote()

            stockRepository.saveStocks(stocks)
            storeRepository.saveStores(stores)
            supplierRepository.saveSuppliers(suppliers)

            Result.success(Unit)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}