package com.arghamnegargroup.core.features.document.domain.model

import android.os.Parcelable
import androidx.room.*
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Document(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @SerializedName("BookerStoreID")
    var bookerStoreID: Int? = null,

    @SerializedName("BookerWorkstationID")
    var bookerWorkstationID: Int? = null,

    @SerializedName("Comment")
    var comment: String? = null,

    @SerializedName("CreationUser")
    var creationUser: String? = null,

    @SerializedName("CustomerID")
    var customerID: String? = null,

    @SerializedName("DepartmentID")
    var departmentID: String? = null,

    @SerializedName("DocumentDate")
    var documentDate: String? = null,

    @SerializedName("DocumentID")
    var documentID: String? = null,

    @SerializedName("DocumentNumber")
    var documentNumber: String? = null,

    @SerializedName("DocumentType")
    var documentType: Int = 0,

    @SerializedName("ExpectedRecieveDate")
    var expectedReceiveDate: String? = null,

    @SerializedName("IsBonus")
    var isBonus: Boolean? = null,

    @SerializedName("Items")
    var items: List<Item>? = null,

    @Transient
    var orgItems: List<Item>? = null,

    @SerializedName("Reason")
    var reason: Int? = null,

    @SerializedName("SourceStock")
    var sourceStock: String? = null,

    @SerializedName("SourceStockID")
    var sourceStockID: String? = null,

    @SerializedName("SupplierID")
    var supplierID: String? = null,

    @SerializedName("SupplierName")
    var supplierName: String? = null,

    @SerializedName("TargetStock")
    var targetStock: String? = null,

    @SerializedName("TargetStockID")
    var targetStockID: String? = null,

    @SerializedName("ThirdPartyID")
    var thirdPartyID: String? = null,

    @SerializedName("ThirdPartyName")
    var thirdPartyName: String? = null,

    @SerializedName("UsageType")
    var usageType: Int? = null,

    var status: Status = Status.Voided,

    @Transient
    var tileId: Int = 0
) : Parcelable