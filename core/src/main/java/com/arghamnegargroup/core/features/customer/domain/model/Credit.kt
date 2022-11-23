package com.arghamnegargroup.core.features.customer.domain.model


import com.google.gson.annotations.SerializedName

data class Credit(
    @SerializedName("CurrentCredit")
    var currentCredit: Double,
    @SerializedName("CurrentPoint")
    val currentPoint: Int?,
    @SerializedName("PartialPaymentCredit")
    val partialPaymentCredit: Int?,
    @SerializedName("RemainCredit")
    var remainCredit: Double,
    @SerializedName("TotalPoint")
    val totalPoint: Int?
) {
    fun addToCredit(value: Double) {
        this.currentCredit += value
    }

    fun addToRemain(value: Double) {
        this.remainCredit += value
    }

    fun minusFromCredit(value: Double) {
        this.currentCredit -= value
    }

    fun minusFromRemain(value: Double) {
        this.remainCredit -= value
    }

}