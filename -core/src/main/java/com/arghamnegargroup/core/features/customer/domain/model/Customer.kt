package com.arghamnegargroup.core.features.customer.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Customer(
    @SerializedName("Address")
    val address: String? = null,
    @SerializedName("AgentID")
    val agentID: String? = null,
    @SerializedName("Birthday")
    val birthday: String? = null,
    @SerializedName("CreationDate")
    val creationDate: String? = null,
    @SerializedName("CurrentCredit")
    val currentCredit: Int? = null,
    @SerializedName("CurrentPoint")
    val currentPoint: Int? = null,
    @SerializedName("CustomerCode")
    val customerCode: String? = null,
    @SerializedName("CustomerID")
    var customerID: String? = null,
    @SerializedName("CustomerImage")
    val customerImage: String? = null,
    @SerializedName("CustomerImageUrl")
    val customerImageUrl: String? = null,
    @SerializedName("Email")
    val email: String? = null,
    @SerializedName("FirstName")
    val firstName: String? = null,
    @SerializedName("GroupName")
    val groupName: String? = null,
    @SerializedName("IsActive")
    val isActive: Boolean? = null,
    @SerializedName("IsMale")
    val isMale: Boolean? = null,
    @SerializedName("LastName")
    val lastName: String? = null,
    @SerializedName("Latitude")
    val latitude: Int? = null,
    @SerializedName("Longitude")
    val longitude: Int? = null,
    @SerializedName("Mobile")
    val mobile: String? = null,
    @SerializedName("NationalID")
    val nationalID: String? = null,
    @SerializedName("Password")
    val password: String? = null,
    @SerializedName("Phone")
    val phone: String? = null,
    @SerializedName("StoreID")
    val storeID: Int? = null,
    @SerializedName("StoreName")
    val storeName: String? = null,
    @SerializedName("TotalPurchase")
    val totalPurchase: Int? = null,
    @SerializedName("CustomFields")
    val customFields: List<String>? = emptyList(),
    @SerializedName("Country")
    val country: String? = null,
    @SerializedName("State")
    val state: String? = null,
    @SerializedName("City")
    val city: String? = null,
    @SerializedName("Area")
    val area: String? = null,
) : Parcelable {

    fun getFullName(): String {
        var fullName = ""
        if (firstName != null && lastName != null)
            fullName = "$firstName $lastName"
        else if (firstName != null && lastName.isNullOrEmpty())
            fullName = firstName
        else if (firstName.isNullOrEmpty() && lastName != null)
            fullName = lastName
        return fullName.trim()
    }


    constructor(
        firstName: String?,
        lastName: String?,
        code: String,
        country: String?,
        state: String?,
        city: String?,
        area: String?,
        address: String?
    ) :
            this(
                firstName = firstName, lastName = lastName, mobile = code, customerCode = code,
                country = country, state = state, city = city, area = area, address = address
            )

    constructor(code: String, firstName: String?, lastName: String?) :
            this(firstName = firstName, lastName = lastName, mobile = code, customerCode = code)

}

class NoSuchCustomerFound : Exception("مشتری یافت نشد.")
class CustomerExists : Exception("مشتری با اطلاعات فعلی موجود است.")