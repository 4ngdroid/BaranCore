package com.arghamnegargroup.core.di

import com.arghamnegargroup.core.features.auth.data.repository.AuthRepositoryImpl
import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository
import com.arghamnegargroup.core.features.connectivity.data.pref.ConnectionPreferences
import com.arghamnegargroup.core.features.connectivity.data.repository.ConnectionRepositoryImpl
import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.dictionary.data.repository.DictionaryRepositoryImpl
import com.arghamnegargroup.core.features.dictionary.domain.repository.DictionaryRepository
import com.arghamnegargroup.core.features.document.data.repository.DocumentRepositoryImpl
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.invoice.data.repository.InvoiceRepositoryImpl
import com.arghamnegargroup.core.features.invoice.domain.repository.InvoiceRepository
import com.arghamnegargroup.core.features.item.data.repository.ItemRepositoryImpl
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository
import com.arghamnegargroup.core.features.quickitems.data.repository.QuickItemsRepositoryImpl
import com.arghamnegargroup.core.features.quickitems.domain.repository.QuickItemsRepository
import com.arghamnegargroup.core.features.section.data.repository.SectionRepositoryImpl
import com.arghamnegargroup.core.features.section.domain.repository.SectionRepository
import com.arghamnegargroup.core.features.stock.data.pref.StockPreferences
import com.arghamnegargroup.core.features.stock.data.repository.StockRepositoryImpl
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository
import com.arghamnegargroup.core.features.store.data.repository.StoreRepositoryImpl
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository
import com.arghamnegargroup.core.features.store.pref.StorePreferences
import com.arghamnegargroup.core.features.supplier.data.repository.SupplierRepositoryImpl
import com.arghamnegargroup.core.features.supplier.domain.repository.SupplierRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideConnectionRepository(connectionPreferences: ConnectionPreferences): ConnectionRepository {
        return ConnectionRepositoryImpl(connectionPreferences)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        api: BaranApi,
        db: BaranDatabase,
        connectionRepository: ConnectionRepository,
    ): AuthRepository {
        return AuthRepositoryImpl(db, api, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideStockRepository(
        api: BaranApi,
        db: BaranDatabase,
        preferences: StockPreferences,
        connectionRepository: ConnectionRepository,
    ): StockRepository {
        return StockRepositoryImpl(db, api, preferences, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideStoreRepository(
        api: BaranApi,
        db: BaranDatabase,
        preferences: StorePreferences,
        connectionRepository: ConnectionRepository,
    ): StoreRepository {
        return StoreRepositoryImpl(db, api, preferences, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideSupplierRepository(
        api: BaranApi,
        db: BaranDatabase,
        connectionRepository: ConnectionRepository,
    ): SupplierRepository {
        return SupplierRepositoryImpl(db, api, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideDictionaryRepository(
        api: BaranApi,
        connectionRepository: ConnectionRepository,
    ): DictionaryRepository {
        return DictionaryRepositoryImpl(api, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideDocumentRepository(
        api: BaranApi,
        db: BaranDatabase,
        connectionRepository: ConnectionRepository,
    ): DocumentRepository {
        return DocumentRepositoryImpl(api, db, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideItemRepository(
        api: BaranApi,
        db: BaranDatabase,
        connectionRepository: ConnectionRepository,
    ): ItemRepository {
        return ItemRepositoryImpl(api, db, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideQuickItemRepository(
        api: BaranApi,
        db: BaranDatabase,
        connectionRepository: ConnectionRepository
    ): QuickItemsRepository {
        return QuickItemsRepositoryImpl(db, api, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideSectionRepository(
        api: BaranApi,
        connectionRepository: ConnectionRepository,
    ): SectionRepository {
        return SectionRepositoryImpl(api, connectionRepository)
    }

    @Provides
    @Singleton
    fun provideInvoiceRepository(
        api: BaranApi,
        connectionRepository: ConnectionRepository
    ): InvoiceRepository {
        return InvoiceRepositoryImpl(api, connectionRepository)
    }
}