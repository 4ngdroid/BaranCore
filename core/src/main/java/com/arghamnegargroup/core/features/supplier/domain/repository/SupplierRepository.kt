package com.arghamnegargroup.core.features.supplier.domain.repository

import com.arghamnegargroup.core.features.supplier.domain.model.Supplier

interface SupplierRepository {

    suspend fun getSuppliersLocal(): List<Supplier>

    suspend fun getSuppliersRemote(): List<Supplier>

    suspend fun saveSuppliers(list: List<Supplier>)
}