package com.arghamnegargroup.core.features.document.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.model.Status
import com.arghamnegargroup.core.features.item.domain.model.Item

@Dao
interface DocumentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDocument(document: Document) : Long

    @Query("UPDATE document SET sourceStockID = :sourceStockId, sourceStock = :sourceStock WHERE id = :id")
    suspend fun setSourceStock(id: Int, sourceStockId: String?, sourceStock: String?)

    @Query("UPDATE document SET targetStockID = :targetStockId, targetStock = :targetStock WHERE id = :id")
    suspend fun setTargetStock(id: Int, targetStockId: String?, targetStock: String?)

    @Query("UPDATE document SET thirdPartyID = :thirdPartyId, thirdPartyName = :thirdPartyName WHERE id = :id")
    suspend fun setThirdParty(id: Int, thirdPartyId: String?, thirdPartyName: String?)

    @Query("UPDATE document SET supplierID = :supplierId, supplierName = :supplier WHERE id = :id")
    suspend fun setSupplier(id: Int, supplierId: String?, supplier: String?)

    @Query("UPDATE document SET items = :items, status = 'Draft' WHERE id = :id")
    suspend fun setItems(id: Int, items: List<Item>)

    @Query("DELETE FROM document WHERE id = :id")
    suspend fun deleteDocument(id: Int)

    @Query("UPDATE document SET status = :status WHERE id = :id")
    suspend fun setStatus(id: Int, status: Status)

    @Query("SELECT * FROM document ORDER BY id DESC LIMIT 1")
    suspend fun getLastDocument(): Document?

}