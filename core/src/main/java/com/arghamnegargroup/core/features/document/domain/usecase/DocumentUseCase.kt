package com.arghamnegargroup.core.features.document.domain.usecase

data class DocumentUseCase(
    val bookDocument: BookDocument,
    val getDocumentInfo: GetDocumentInfo,
    val saveBarcodeFile: SaveBarcodeFile,
    val saveDocument: SaveDocument,
    val setSourceStock: SetSourceStock,
    val setTargetStock: SetTargetStock,
    val setThirdParty: SetThirdParty,
    val setSupplier: SetSupplier,
    val setItems: SetItems,
    val deleteDocument: DeleteDocument,
    val setStatus: SetStatus,
    val getLastDocument: GetLastDocument,
)
