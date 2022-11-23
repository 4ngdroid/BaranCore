package com.arghamnegargroup.core.features.supplier.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier

@Dao
interface SupplierDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveSupplier(entity: Supplier)

    @Query("DELETE FROM supplier")
    suspend fun deleteSuppliers()

    @Query("SELECT * FROM supplier")
    suspend fun getSuppliers(): List<Supplier>
}