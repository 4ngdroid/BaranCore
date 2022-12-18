package com.arghamnegargroup.core.features.item.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.item.domain.model.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveItem(entity: Item)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveItems(entities: List<Item>)

    @Query("DELETE FROM item")
    suspend fun deleteItems()

    @Query("SELECT * FROM item")
    suspend fun getItems(): List<Item>

}