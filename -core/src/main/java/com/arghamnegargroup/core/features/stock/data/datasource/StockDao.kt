package com.arghamnegargroup.core.features.stock.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.stock.domain.model.Stock

@Dao
interface StockDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveStock(entity: Stock)

    @Query("DELETE FROM stock")
    suspend fun deleteStocks()

    @Query("SELECT * FROM stock")
    suspend fun getStocks(): List<Stock>

}