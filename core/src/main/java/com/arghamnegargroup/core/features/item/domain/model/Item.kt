package com.arghamnegargroup.core.features.item.domain.model

import android.os.Parcelable
import androidx.room.Entity
import com.arghamnegargroup.core.features.order.domain.model.OrderItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Item(
    @SerializedName("AllowToRecieve")
    val allowToReceive: Boolean? = null,
    @SerializedName("Attributes")
    val attributes: List<Attribute>? = null,
    @SerializedName("BonusCount")
    val bonusCount: Double? = null,
    @SerializedName("Barcode")
    val barcode: String? = null,
    @SerializedName("Brand")
    val brand: String? = null,
    @SerializedName("BrandID")
    val brandId: String? = null,
    @SerializedName("BulkPrice")
    val bulkPrice: Double? = null,
    @SerializedName("Collection")
    val collections: List<Collection>? = null,
    @SerializedName("ConsumerPrice")
    val consumerPrice: Double? = null,
    @SerializedName("ContractConsumerPrice")
    val contractConsumerPrice: Double? = null,
    @SerializedName("ContractID")
    val contractID: String? = null,
    @SerializedName("ContractNumber")
    val contractNumber: String? = null,
    @SerializedName("ContractType")
    val contractType: String? = null,
    @SerializedName("ContractTypeID")
    val contractTypeId: Int? = null,
    @SerializedName("Cost")
    val cost: Double? = null,
    @SerializedName("CustomFields")
    val customFields: List<CustomField>? = null,
    @SerializedName("CurrentDiscount")
    val currentDiscount: Double? = null,
    @SerializedName("CurrentUnitCount")
    val currentUnitCount: Double? = null,
    @SerializedName("DamagedCount")
    val damagedCount: Double? = null,
    @SerializedName("DeactiveConsumerPrice")
    val deactivatedConsumerPrice: Double? = null,
    @SerializedName("DeactivePrice")
    val deactivatedPrice: Double? = null,
    @SerializedName("DepartmentID")
    val departmentId: String? = null,
    @SerializedName("DepartmentName")
    val departmentName: String? = null,
    @SerializedName("Description")
    val description: String? = null,
    @SerializedName("Discount")
    val discount: Double? = null,
    @SerializedName("Discount1")
    val discount1: Double? = null,
    @SerializedName("Discount2")
    val discount2: Double? = null,
    @SerializedName("Discount3")
    val discount3: Double? = null,
    @SerializedName("Discount4")
    val discount4: Double? = null,
    @SerializedName("Discount5")
    val discount5: Double? = null,
    @SerializedName("ImageUrl")
    val imageUrl: String? = null,
    @SerializedName("IsNotFound")
    val isNotFound: Boolean? = null,
    @SerializedName("IsNotInOrder")
    val isNotInOrder: Boolean? = null,
    @SerializedName("ItemID")
    val itemId: String? = null,
    @SerializedName("LineItemID")
    val lineItemId: Int? = null,
    @SerializedName("ManufacturerPrice")
    val manufacturerPrice: Double? = null,
    @SerializedName("MaximumOrderOverage")
    val maximumOrderOverage: Double? = null,
    @SerializedName("Name")
    val name: String? = null,
    @SerializedName("NameInPOS")
    val nameInPOS: String? = null,
    @SerializedName("NegativeCost")
    val negativeCost: Double? = null,
    @SerializedName("NetCost")
    val netCost: Double? = null,
    @SerializedName("OrderCount")
    val orderCount: Double? = null,
    @SerializedName("PackCount")
    val packCount: Double? = null,
    @SerializedName("PackNumber")
    val packNumber: Double? = null,
    @SerializedName("PackUnitCount")
    val packUnitCount: Double? = null,
    @SerializedName("ParentID")
    val parentId: String? = null,
    @SerializedName("PositiveCost")
    val positiveCost: Double? = null,
    @SerializedName("Price")
    val price: Double? = null,
    @SerializedName("PriceWithTax")
    val priceWithTax: Double? = null,
    @SerializedName("Quantity")
    val quantity: Double? = null,
    @SerializedName("RecieveMoreThanOrder")
    val receiveMoreThanOrder: Boolean? = null,
    @SerializedName("ScannedCount")
    val scannedCount: Double? = null,
    @SerializedName("Status")
    val status: Boolean? = null,
    @SerializedName("StockQuantity")
    val stockQuantity: Double? = null,
    @SerializedName("StockSection")
    val stockSection: String? = null,
    @SerializedName("SKU")
    val sku: String? = null,
    @SerializedName("SupplierDiscount")
    val supplierDiscount: Double? = null,
    @SerializedName("SupplierDiscountPercent")
    val supplierDiscountPercent: Double? = null,
    @SerializedName("Tax")
    val tax: Double? = null,
    @SerializedName("TemporaryPrice")
    val temporaryPrice: Double? = null,
    @SerializedName("Toll")
    val toll: Double? = null,
    @SerializedName("TypeID")
    val typeId: Int? = null,
    @SerializedName("UnitOfMeasureID")
    val unitOfMeasureId: Int? = null,

    @Transient
    var orderItem: Boolean? = null,
) : Parcelable

fun Item.toOrderItem(): OrderItem {
    return OrderItem(
        barcode = barcode,
        description = description,
        details = null,
        discount = discount,
        discounts = null,
        isDelivery = null,
        isPriceWithTax = null,
        itemId = itemId,
        lineItemId = lineItemId,
        itemName = name,
        netAmount = null,
        operationType = null,
        orderId = null,
        price = price,
        quantity = quantity,
        reasonId = null,
        sku = sku,
        stockId = null,
        tax = tax,
        type = typeId,
    )
}