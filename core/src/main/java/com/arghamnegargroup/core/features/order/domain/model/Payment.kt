package com.arghamnegargroup.core.features.order.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Payment(
    @SerializedName("AccountNumber")//Shomare hesab
    var accountNumber: String? = null,
    @SerializedName("Amount")//mablaq
    var amount: Double? = null,
    @SerializedName("BankName")//esme bank
    var bankName: String? = null,
    @SerializedName("DueDate")//tarikh pardakht -
    var dueDate: String? = null,
    @SerializedName("ExchangeAmount")//nerkh arz
    val exchangeAmount: Double? = null,
    @SerializedName("GiftCardID")//shomare gift cart
    val giftCardId: String? = null,
    @SerializedName("LineItemID")//
    var lineItemId: Int? = null,
    @SerializedName("PANNumber")//shomare card moshtari
    val PANNumber: String? = null,
    @SerializedName("PaymentDate")//tarikh pardakht (tarikh check)
    var paymentDate: String? = null,
    @SerializedName("RefrenceNumber")//code marja pos bank
    val referenceNumber: String? = null,
    @SerializedName("SVCNumber")//
    val SVCNumber: String? = null,
    @SerializedName("SerialNumber")//pos serial number or giftcard SN
    val serialNumber: String? = null,
    @SerializedName("TerminalID")//pos
    val terminalId: String? = null,
    @SerializedName("TypeID")//1=naqd
    var typeId: Int? = null,
    @Transient var typeCode: Int? = null,
    @Transient var typeName: String? = null,
    @Transient var isPosOnline: Boolean = false
):Parcelable