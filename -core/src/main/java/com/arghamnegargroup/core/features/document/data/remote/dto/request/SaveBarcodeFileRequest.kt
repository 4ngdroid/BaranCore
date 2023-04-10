package com.arghamnegargroup.core.features.document.data.remote.dto.request

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SaveBarcodeFileRequest(
        @SerializedName("document")
        @Expose
        val document: Document,

        @SerializedName("saveInDatabase")
        @Expose
        val saveInDatabase: Boolean?

) {
    data class Document(
            @SerializedName("Comment")
            @Expose
            var comment: String?,
            @SerializedName("CreationUser")
            @Expose
            var creationUser: String?,
            @SerializedName("Items")
            @Expose
            var items: List<Item>? = null,
    )

    data class Item(
            @SerializedName("Barcode")
            @Expose
            val barcode: String?,

            @SerializedName("Quantity")
            @Expose
            var quantity: Double,

            @SerializedName("StockSection")
            @Expose
            var stockSection: String? = null
    )
}