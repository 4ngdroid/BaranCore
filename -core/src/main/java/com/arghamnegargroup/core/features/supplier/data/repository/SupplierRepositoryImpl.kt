package com.arghamnegargroup.core.features.supplier.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.arghamnegargroup.core.features.supplier.domain.repository.SupplierRepository

class SupplierRepositoryImpl(
    private val db: BaranDatabase,
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : SupplierRepository {

    override suspend fun getSuppliersLocal(): List<Supplier> {
        return db.supplierDao().getSuppliers()
    }

    @Throws(Throwable::class)
    override suspend fun getSuppliersRemote(): List<Supplier> {
        return api.getSuppliers(connectionRepository.getUrl(Endpoints.GET_ALL_SUPPLIERS)).result ?: emptyList()
    }

    override suspend fun saveSuppliers(list: List<Supplier>) {
        db.storeDao().deleteStores()
        list.forEach { item -> db.supplierDao().saveSupplier(item) }
    }


}