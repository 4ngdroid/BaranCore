package com.arghamnegargroup.core.features.item.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.item.domain.model.ItemBarcode

@Dao
interface ItemBarcodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveItemBarcodes(itemBarcodes: List<ItemBarcode>)

    @Query("SELECT * FROM itemBarcode WHERE barcode = :barcode")
    suspend fun getItemBarcode(barcode: String): ItemBarcode?

    @Query("DELETE FROM itemBarcode")
    suspend fun deleteItemBarcodes(): Int

}