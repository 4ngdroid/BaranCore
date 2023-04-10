package com.arghamnegargroup.core.features.store.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.store.domain.model.Store

@Dao
interface StoreDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveStore(entity: Store)

    @Query("DELETE FROM store")
    suspend fun deleteStores()

    @Query("SELECT * FROM store")
    suspend fun getStores(): List<Store>

}