package com.arghamnegargroup.core.features.order.domain.model

import android.os.Parcelable
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class OrderItem(
    @SerializedName("Barcode")
    val barcode: String? = null,
    @SerializedName("Description")
    val description: String? = null,
    @SerializedName("Details")
    val details: List<Detail>? = null,
    @SerializedName("Discount")
    val discount: Double? = null,
    @SerializedName("Discounts")
    val discounts: List<OrderDiscount>? = null,
    @SerializedName("IsDelivery")
    val delivery: Boolean? = null,
    @SerializedName("IsPriceWithTax")
    val priceWithTax: Boolean? = null,
    @SerializedName("ItemId")
    val itemId: String? = null,
    @SerializedName("LineItemID")
    val lineItemId: Int? = null,
    @SerializedName("ItemName")
    val itemName: String? = null,
    @SerializedName("NetAmount")
    val netAmount: Double? = null,
    @SerializedName("OperationType")
    val operationType: Int? = 1,
    @SerializedName("OrderId")
    val orderId: String? = null,
    @SerializedName("Price")
    val price: Double? = null,
    @SerializedName("Quantity")
    val quantity: Double? = null,
    @SerializedName("ReasonID")
    val reasonId: Int? = null,
    @SerializedName("SKU")
    val sku: String? = null,
    @SerializedName("StockId")
    val stockId: String? = null,
    @SerializedName("Tax")
    val tax: Double? = null,
    @SerializedName("Type")
    val type: Int? = null,
) : Parcelable

fun OrderItem.toItem(): Item {
    return Item(
        allowToReceive = null,
        attributes = null,
        bonusCount = null,
        brand = null,
        brandId = null,
        bulkPrice = null,
        barcode = barcode,
        collections = null,
        consumerPrice = null,
        contractConsumerPrice = null,
        contractID = null,
        contractNumber = null,
        contractType = null,
        contractTypeId = null,
        cost = null,
        customFields = null,
        currentDiscount = null,
        currentUnitCount = null,
        damagedCount = null,
        deactivatedConsumerPrice = null,
        deactivatedPrice = null,
        departmentId = null,
        departmentName = null,
        description = description,
        discount = discount,
        discount1 = null,
        discount2 = null,
        discount3 = null,
        discount4 = null,
        discount5 = null,
        imageUrl = null,
        notFound = null,
        notInOrder = null,
        itemId = itemId ?: UUID(0L, 0L).toString(),
        lineItemId = lineItemId,
        manufacturerPrice = null,
        maximumOrderOverage = null,
        name = itemName,
        nameInPOS = null,
        negativeCost = null,
        netCost = null,
        orderCount = null,
        packCount = null,
        packNumber = null,
        packUnitCount = null,
        parentId = null,
        positiveCost = null,
        priceWithTax = null,
        price = price,
        quantity = quantity,
        receiveMoreThanOrder = null,
        scannedCount = null,
        status = null,
        stockQuantity = null,
        stockSection = null,
        supplierDiscount = null,
        supplierDiscountPercent = null,
        sku = sku,
        tax = tax,
        temporaryPrice = null,
        toll = null,
        typeId = null,
        unitOfMeasureId = null,
        orderItem = null,
    )
}