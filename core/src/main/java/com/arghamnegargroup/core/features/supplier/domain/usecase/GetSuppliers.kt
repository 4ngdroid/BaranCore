package com.arghamnegargroup.core.features.supplier.domain.usecase

import com.arghamnegargroup.core.features.supplier.domain.model.Supplier
import com.arghamnegargroup.core.features.supplier.domain.repository.SupplierRepository

class GetSuppliers(
    private val repository: SupplierRepository,
) {

    suspend operator fun invoke(): Result<List<Supplier>> {
        return try {
            val suppliers = repository.getSuppliersRemote()
            repository.saveSuppliers(suppliers)
            Result.success(suppliers)
        } catch (e: Throwable) {
            Result.success(repository.getSuppliersLocal())
        }
    }
}