package com.arghamnegargroup.core.features.item.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.arghamnegargroup.core.features.order.domain.model.OrderItem
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
@Entity
data class Item(
    @SerializedName("AllowToRecieve")
    var allowToReceive: Boolean = false,
    @SerializedName("Attributes")
    var attributes: List<Attribute>? = null,
    @SerializedName("BonusCount")
    var bonusCount: Double = 0.0,
    @SerializedName("Barcode")
    var barcode: String? = null,
    @SerializedName("Brand")
    var brand: String? = null,
    @SerializedName("BrandID")
    var brandId: String? = null,
    @SerializedName("BulkPrice")
    var bulkPrice: Double? = null,
    @SerializedName("Collection")
    var collections: List<Collection>? = null,
    @SerializedName("ConsumerPrice")
    var consumerPrice: Double? = null,
    @SerializedName("ContractConsumerPrice")
    var contractConsumerPrice: Double? = null,
    @SerializedName("ContractID")
    var contractID: String? = null,
    @SerializedName("ContractNumber")
    var contractNumber: String? = null,
    @SerializedName("ContractType")
    var contractType: String? = null,
    @SerializedName("ContractTypeID")
    var contractTypeId: Int? = null,
    @SerializedName("Cost")
    var cost: Double? = null,
    @SerializedName("CustomFields")
    var customFields: List<CustomField>? = null,
    @SerializedName("CurrentDiscount")
    var currentDiscount: Double? = null,
    @SerializedName("CurrentUnitCount")
    var currentUnitCount: Double? = null,
    @SerializedName("DamagedCount")
    var damagedCount: Double? = null,
    @SerializedName("DeactiveConsumerPrice")
    var deactivatedConsumerPrice: Double? = null,
    @SerializedName("DeactivePrice")
    var deactivatedPrice: Double? = null,
    @SerializedName("DepartmentID")
    var departmentId: String? = null,
    @SerializedName("DepartmentName")
    var departmentName: String? = null,
    @SerializedName("Description")
    var description: String? = null,
    @SerializedName("Discount")
    var discount: Double? = null,
    @SerializedName("Discount1")
    var discount1: Double? = null,
    @SerializedName("Discount2")
    var discount2: Double? = null,
    @SerializedName("Discount3")
    var discount3: Double? = null,
    @SerializedName("Discount4")
    var discount4: Double? = null,
    @SerializedName("Discount5")
    var discount5: Double? = null,
    @SerializedName("ImageUrl")
    var imageUrl: String? = null,
    @SerializedName("IsNotFound")
    var notFound: Boolean? = null,
    @SerializedName("IsNotInOrder")
    var notInOrder: Boolean? = null,
    @PrimaryKey(autoGenerate = false)
    @SerializedName("ItemID")
    var itemId: String = UUID(0L, 0L).toString(),
    @SerializedName("LineItemID")
    var lineItemId: Int? = null,
    @SerializedName("ManufacturerPrice")
    var manufacturerPrice: Double? = null,
    @SerializedName("MaximumOrderOverage")
    var maximumOrderOverage: Double? = null,
    @SerializedName("Name")
    var name: String? = null,
    @SerializedName("NameInPOS")
    var nameInPOS: String? = null,
    @SerializedName("NegativeCost")
    var negativeCost: Double? = null,
    @SerializedName("NetCost")
    var netCost: Double? = null,
    @SerializedName("OrderCount")
    var orderCount: Double = 0.0,
    @SerializedName("PackCount")
    var packCount: Double = 0.0,
    @SerializedName("PackNumber")
    var packNumber: Double? = null,
    @SerializedName("PackUnitCount")
    var packUnitCount: Double? = null,
    @SerializedName("ParentID")
    var parentId: String? = null,
    @SerializedName("PositiveCost")
    var positiveCost: Double? = null,
    @SerializedName("Price")
    var price: Double = 0.0,
    @SerializedName("PriceWithTax")
    var priceWithTax: Double = 0.0,
    @SerializedName("Quantity")
    var quantity: Double = 0.0,
    @SerializedName("RecieveMoreThanOrder")
    var receiveMoreThanOrder: Boolean = false,
    @SerializedName("ScannedCount")
    var scannedCount: Double = 0.0,
    @SerializedName("Status")
    var status: Boolean = false,
    @SerializedName("StockQuantity")
    var stockQuantity: Double = 0.0,
    @SerializedName("StockSection")
    var stockSection: String? = null,
    @SerializedName("SKU")
    var sku: String? = null,
    @SerializedName("SupplierDiscount")
    var supplierDiscount: Double? = null,
    @SerializedName("SupplierDiscountPercent")
    var supplierDiscountPercent: Double? = null,
    @SerializedName("Tax")
    var tax: Double? = null,
    @SerializedName("TemporaryPrice")
    var temporaryPrice: Double? = null,
    @SerializedName("Toll")
    var toll: Double? = null,
    @SerializedName("TypeID")
    var typeId: Int? = null,
    @SerializedName("UnitOfMeasureID")
    var unitOfMeasureId: Int? = null,

    @Transient
    var orderItem: Boolean? = null,
) : Parcelable {

    @Ignore
    constructor(barcode: String? = null, itemId: String, name: String?) : this(
        barcode = barcode, bonusCount = 0.0, bulkPrice = 0.0, contractConsumerPrice = null,
        consumerPrice = 0.0, contractID = null, contractTypeId = null, cost = null, currentDiscount = 0.0,
        damagedCount = null, departmentId = null, departmentName = null, description = null, notFound = null, notInOrder = null,
        itemId = itemId, lineItemId = null, maximumOrderOverage = null, name = name, orderCount = 0.0, packCount = 0.0,
        packNumber = null, packUnitCount = null, parentId = null, price = 0.0, quantity = 0.0, receiveMoreThanOrder = false,
        scannedCount = 0.0, stockQuantity = 0.0, stockSection = null, supplierDiscountPercent = null, temporaryPrice = null,
        typeId = null, unitOfMeasureId = null, priceWithTax = 0.0,
    )
}

fun Item.toOrderItem(): OrderItem {
    return OrderItem(
        barcode = barcode,
        description = description,
        details = null,
        discount = discount,
        discounts = null,
        delivery = null,
        priceWithTax = null,
        itemId = itemId,
        lineItemId = lineItemId,
        itemName = name,
        netAmount = null,
        operationType = 1,
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