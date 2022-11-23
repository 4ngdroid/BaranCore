package com.arghamnegargroup.core.di

import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository
import com.arghamnegargroup.core.features.auth.domain.usecase.AuthUseCase
import com.arghamnegargroup.core.features.auth.domain.usecase.GetUser
import com.arghamnegargroup.core.features.auth.domain.usecase.Login
import com.arghamnegargroup.core.features.connectivity.domain.usecase.Check
import com.arghamnegargroup.core.features.dictionary.domain.repository.DictionaryRepository
import com.arghamnegargroup.core.features.dictionary.domain.usecase.GetDictionaries
import com.arghamnegargroup.core.features.document.domain.repository.DocumentRepository
import com.arghamnegargroup.core.features.document.domain.usecase.*
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository
import com.arghamnegargroup.core.features.item.domain.usecase.*
import com.arghamnegargroup.core.features.section.domain.repository.SectionRepository
import com.arghamnegargroup.core.features.section.domain.usecase.GetStockSection
import com.arghamnegargroup.core.features.section.domain.usecase.GetStockSections
import com.arghamnegargroup.core.features.section.domain.usecase.ItemAssignmentToSection
import com.arghamnegargroup.core.features.section.domain.usecase.SectionUseCase
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository
import com.arghamnegargroup.core.features.stock.domain.usecase.GetStocks
import com.arghamnegargroup.core.features.store.domain.repository.StoreRepository
import com.arghamnegargroup.core.features.store.domain.usecase.GetStores
import com.arghamnegargroup.core.features.supplier.domain.repository.SupplierRepository
import com.arghamnegargroup.core.features.supplier.domain.usecase.GetSuppliers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideCheckUseCase(
        stockRepository: StockRepository,
        storeRepository: StoreRepository,
        supplierRepository: SupplierRepository,
    ): Check {
        return Check(stockRepository, storeRepository, supplierRepository)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(
        authRepository: AuthRepository,
    ): AuthUseCase {
        return AuthUseCase(
            login = Login(authRepository),
            getUser = GetUser(authRepository)
        )
    }

    @Provides
    @Singleton
    fun provideStockUseCase(repository: StockRepository): GetStocks {
        return GetStocks(repository)
    }

    @Provides
    @Singleton
    fun provideStoreUseCase(repository: StoreRepository): GetStores {
        return GetStores(repository)
    }

    @Provides
    @Singleton
    fun provideSupplierUseCase(repository: SupplierRepository): GetSuppliers {
        return GetSuppliers(repository)
    }

    @Provides
    @Singleton
    fun provideItemUseCase(
        authRepository: AuthRepository,
        itemRepository: ItemRepository,
        stockRepository: StockRepository,
    ): ItemUseCase {
        return ItemUseCase(
            getItemInfo = GetItemInfo(itemRepository, stockRepository),
            saveItemInfo = SaveItemInfo(itemRepository),
            search = Search(itemRepository, stockRepository, authRepository),
            getItemBarcode = GetItemBarcode(itemRepository),
            saveItemBarcodes = SaveItemBarcodes(itemRepository)
        )
    }

    @Provides
    @Singleton
    fun provideDictionaryUseCase(
        dictionaryRepository: DictionaryRepository,
    ): GetDictionaries {
        return GetDictionaries(dictionaryRepository)
    }

    @Provides
    @Singleton
    fun provideDocumentUseCase(
        documentRepository: DocumentRepository,
    ): DocumentUseCase {
        return DocumentUseCase(
            bookDocument = BookDocument(documentRepository),
            getDocumentInfo = GetDocumentInfo(documentRepository),
            saveBarcodeFile = SaveBarcodeFile(documentRepository),
            saveDocument = SaveDocument(documentRepository),
            setSourceStock = SetSourceStock(documentRepository),
            setTargetStock = SetTargetStock(documentRepository),
            setThirdParty = SetThirdParty(documentRepository),
            setSupplier = SetSupplier(documentRepository),
            setItems = SetItems(documentRepository),
            deleteDocument = DeleteDocument(documentRepository),
            setStatus = SetStatus(documentRepository),
            getLastDocument = GetLastDocument(documentRepository)
        )
    }


    @Provides
    @Singleton
    fun provideSectionUseCase(
        sectionRepository: SectionRepository,
        stockRepository: StockRepository,
    ): SectionUseCase {
        return SectionUseCase(
            getStockSection = GetStockSection(sectionRepository, stockRepository),
            getStockSections = GetStockSections(sectionRepository),
            itemAssignmentToSection = ItemAssignmentToSection(sectionRepository)
        )
    }

}