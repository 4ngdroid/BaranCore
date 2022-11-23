package com.arghamnegargroup.core.features.order.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Order(
    @SerializedName("Address")
    val address: String? = null,
    @SerializedName("CustomerId")
    val customerId: String? = null,
    @SerializedName("SaleChannelId")
    val saleChannelId:Int,
    @SerializedName("CustomerName")
    val customerName: String? = null,
    @SerializedName("DeliveryCost")
    val deliveryCost: Int? = null,
    @SerializedName("DeliveryDate")
    val deliveryDate: String? = null,
    @SerializedName("DeliveryFromTime")
    val deliveryFromTime: String? = null,
    @SerializedName("DeliveryToTime")
    val deliveryToTime: String? = null,
    @SerializedName("DeliveryTypeId")
    val deliveryTypeId: Int? = null,
    @SerializedName("Description")
    val description: String? = null,
    @SerializedName("Discounts")
    val discounts: List<OrderDiscount>? = null,
    @SerializedName("ExpectedAmount")
    val expectedAmount: Int? = null,
    @SerializedName("Id")
    val id: String? = null,
    @SerializedName("Items")
    val items: List<OrderItem>? = null,
    @SerializedName("OrderNumber")
    val orderNumber: String? = null,
    @SerializedName("Payments")
    val payments: List<Payment>? = null,
    @SerializedName("SitNumber")
    val sitNumber: String? = null,
    @SerializedName("StoreId")
    val storeId: String? = null,
    @SerializedName("UserId")
    val userId: String? = null,
    @SerializedName("WorkstationId")
    val workstationId: Int? = null,
    @SerializedName("Details")
    val details: List<Detail>? = null
) : Parcelable