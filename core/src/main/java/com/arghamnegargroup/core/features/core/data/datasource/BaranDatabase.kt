package com.arghamnegargroup.core.features.core.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arghamnegargroup.core.features.auth.data.datasource.AuthDao
import com.arghamnegargroup.core.features.auth.domain.model.User
import com.arghamnegargroup.core.features.core.domain.util.converter.IntConverter
import com.arghamnegargroup.core.features.core.domain.util.converter.StringConverter
import com.arghamnegargroup.core.features.department.data.datasource.DepartmentDao
import com.arghamnegargroup.core.features.department.domain.model.Department
import com.arghamnegargroup.core.features.department.domain.util.converter.DepartmentConverter
import com.arghamnegargroup.core.features.document.data.datasource.DocumentDao
import com.arghamnegargroup.core.features.document.domain.model.Document
import com.arghamnegargroup.core.features.document.domain.util.converter.StatusConverter
import com.arghamnegargroup.core.features.item.data.datasource.ItemBarcodeDao
import com.arghamnegargroup.core.features.item.data.datasource.ItemDao
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.model.ItemBarcode
import com.arghamnegargroup.core.features.item.domain.util.converter.AttributeConverter
import com.arghamnegargroup.core.features.item.domain.util.converter.CollectionConverter
import com.arghamnegargroup.core.features.item.domain.util.converter.CustomFieldConverter
import com.arghamnegargroup.core.features.item.domain.util.converter.ItemConverter
import com.arghamnegargroup.core.features.stock.data.datasource.StockDao
import com.arghamnegargroup.core.features.stock.domain.model.Stock
import com.arghamnegargroup.core.features.store.data.datasource.StoreDao
import com.arghamnegargroup.core.features.store.domain.model.Store
import com.arghamnegargroup.core.features.supplier.data.datasource.SupplierDao
import com.arghamnegargroup.core.features.supplier.domain.model.Supplier


@Database(
    entities = [
        Store::class, Stock::class, Supplier::class, User::class, Document::class,
        Item::class, Department::class, ItemBarcode::class],
    version = 2,
    exportSchema = false
)

@TypeConverters(
    DepartmentConverter::class,
    StringConverter::class,
    IntConverter::class,
    ItemConverter::class,
    StatusConverter::class,
    CustomFieldConverter::class,
    CollectionConverter::class,
    AttributeConverter::class
)
abstract class BaranDatabase : RoomDatabase() {

    abstract fun authDao(): AuthDao
    abstract fun supplierDao(): SupplierDao
    abstract fun stockDao(): StockDao
    abstract fun storeDao(): StoreDao
    abstract fun documentDao(): DocumentDao
    abstract fun itemBarcodeDao(): ItemBarcodeDao
    abstract fun departmentDao(): DepartmentDao
    abstract fun itemDao(): ItemDao

    companion object {
        const val DATABASE_NAME = "baran_db"
    }
}