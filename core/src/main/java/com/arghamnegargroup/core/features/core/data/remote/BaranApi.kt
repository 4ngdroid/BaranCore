package com.arghamnegargroup.core.features.core.data.remote

import com.arghamnegargroup.core.features.auth.data.remote.dto.request.LoginRequest
import com.arghamnegargroup.core.features.auth.data.remote.dto.response.LoginResponse
import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerCreditRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.CustomerRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.SaveCustomerRequest
import com.arghamnegargroup.core.features.customer.data.dto.request.UseCreditRequest
import com.arghamnegargroup.core.features.customer.data.dto.response.CustomerCreditResponse
import com.arghamnegargroup.core.features.customer.data.dto.response.CustomerResponse
import com.arghamnegargroup.core.features.customer.data.dto.response.SaveCustomerResponse
import com.arghamnegargroup.core.features.customer.data.dto.response.UseCreditResponse
import com.arghamnegargroup.core.features.dictionary.data.remote.request.DictionaryRequest
import com.arghamnegargroup.core.features.dictionary.data.remote.response.DictionaryResponse
import com.arghamnegargroup.core.features.document.data.remote.dto.request.BookStockDocumentRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.request.DocumentInfoRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.request.SaveBarcodeFileRequest
import com.arghamnegargroup.core.features.document.data.remote.dto.response.BookDocumentResponse
import com.arghamnegargroup.core.features.document.data.remote.dto.response.DocumentInfoResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.CalcInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.ReturnInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.request.SaleInvoiceRequest
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.CalcInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.ReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.SaveReturnInvoiceResponse
import com.arghamnegargroup.core.features.invoice.data.remote.dto.response.SaveSaleInvoiceResponse
import com.arghamnegargroup.core.features.item.data.remote.dto.request.ItemInfoRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SaveItemInfoRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SearchRequest
import com.arghamnegargroup.core.features.item.data.remote.dto.response.ItemInfoResponse
import com.arghamnegargroup.core.features.item.data.remote.dto.response.SaveItemInfoResponse
import com.arghamnegargroup.core.features.item.data.remote.dto.response.SearchResponse
import com.arghamnegargroup.core.features.item.domain.model.ItemsResponse
import com.arghamnegargroup.core.features.order.data.dto.request.ResumeSuspendOrderRequest
import com.arghamnegargroup.core.features.order.data.dto.request.SuspendOrderRequest
import com.arghamnegargroup.core.features.order.data.dto.response.ResumeSuspendOrderResponse
import com.arghamnegargroup.core.features.order.data.dto.response.SuspendOrderResponse
import com.arghamnegargroup.core.features.order.data.dto.response.SuspendOrdersResponse
import com.arghamnegargroup.core.features.quickitems.data.remote.dto.response.QuickItemsResponse
import com.arghamnegargroup.core.features.reason.data.remote.dto.request.ReasonsRequest
import com.arghamnegargroup.core.features.reason.data.remote.dto.response.ReasonResponse
import com.arghamnegargroup.core.features.section.data.remote.request.ItemAssignmentRequest
import com.arghamnegargroup.core.features.section.data.remote.request.StockSectionRequest
import com.arghamnegargroup.core.features.section.data.remote.response.ItemAssignmentResponse
import com.arghamnegargroup.core.features.stock.data.remote.dto.response.StockResponse
import com.arghamnegargroup.core.features.store.data.remote.dto.response.StoreResponse
import com.arghamnegargroup.core.features.supplier.data.remote.dto.response.SuppliersResponse
import com.arghamnegargroup.core.features.section.data.remote.response.StockSectionResponse
import com.arghamnegargroup.core.features.section.data.remote.response.StockSectionsResponse
import com.arghamnegargroup.core.features.table.data.dto.response.TableResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface BaranApi {
    @GET
    suspend fun getStores(@Url url: String): StoreResponse

    @GET
    suspend fun getStocks(@Url url: String): StockResponse

    @POST
    suspend fun getDocumentInfo(@Url url: String, @Body request: DocumentInfoRequest): DocumentInfoResponse

    @GET
    suspend fun getSuppliers(@Url url: String): SuppliersResponse

    @POST
    suspend fun getItemInfo(@Url url: String, @Body request: ItemInfoRequest): ItemInfoResponse

    @POST
    suspend fun bookStockDocument(@Url url: String, @Body request: BookStockDocumentRequest): BookDocumentResponse

    @POST
    suspend fun saveBarcodeFile(@Url url: String, @Body request: SaveBarcodeFileRequest): Response<Unit>

    @POST
    suspend fun login(@Url url: String, @Body request: LoginRequest): LoginResponse

    @POST
    suspend fun getStockSection(@Url url: String, @Body request: StockSectionRequest): StockSectionResponse

    @POST
    suspend fun getStockSections(@Url url: String): StockSectionsResponse

    @POST
    suspend fun itemAssignmentToSection(@Url url: String, @Body request: ItemAssignmentRequest): ItemAssignmentResponse

    @Streaming
    @GET
    fun getItemBarcodes(@Url url: String): Response<ResponseBody>

    @POST
    suspend fun searchItem(@Url url: String, @Body request: SearchRequest): SearchResponse

    @POST
    suspend fun getDictionary(@Url url: String, @Body request: DictionaryRequest): DictionaryResponse

    @POST
    suspend fun saveItemInfo(@Url url: String, @Body request: SaveItemInfoRequest): SaveItemInfoResponse

    @POST
    suspend fun getQuickItems(@Url url: String): QuickItemsResponse

    @GET
    suspend fun getTables(@Url url: String): TableResponse

    @POST
    suspend fun getCustomer(@Url url: String, @Body request: CustomerRequest): CustomerResponse

    @POST
    suspend fun saveCustomer(@Url url: String, @Body request: SaveCustomerRequest): SaveCustomerResponse

    @GET
    suspend fun getSuspendOrders(@Url url: String): SuspendOrdersResponse

    @POST
    suspend fun suspendOrder(@Url url: String, @Body request: SuspendOrderRequest): SuspendOrderResponse

    @POST
    suspend fun resumeSuspendOrder(
        @Url url: String,
        @Body request: ResumeSuspendOrderRequest,
    ): ResumeSuspendOrderResponse

    @POST
    suspend fun saveSaleInvoiceByOrder(@Url url: String, @Body request: SaleInvoiceRequest): SaveSaleInvoiceResponse

    @POST
    suspend fun calcInvoice(@Url url: String, @Body request: CalcInvoiceRequest): CalcInvoiceResponse

    @Streaming
    @GET
    suspend fun getItems(@Url url: String): ItemsResponse

    @Streaming
    @GET
    suspend fun _getItems(@Url url: String): ResponseBody

    @POST
    suspend fun getInvoice(@Url url: String, @Body request: ReturnInvoiceRequest): ReturnInvoiceResponse

    @POST
    suspend fun saveReturnInvoice(@Url url: String, @Body request: ReturnInvoiceRequest): SaveReturnInvoiceResponse

    @POST
    suspend fun getCustomerCredit(@Url url: String, @Body request: CustomerCreditRequest): CustomerCreditResponse

    @POST
    suspend fun useCustomerCredit(@Url url: String, @Body request: UseCreditRequest): UseCreditResponse

    @POST
    suspend fun useRemainCredit(@Url url: String, @Body request: UseCreditRequest): UseCreditResponse

    @POST
    suspend fun getReasons(@Url url: String, @Body request: ReasonsRequest): ReasonResponse

}