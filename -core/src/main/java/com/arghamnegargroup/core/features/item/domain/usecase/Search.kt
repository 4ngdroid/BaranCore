package com.arghamnegargroup.core.features.item.domain.usecase

import com.arghamnegargroup.core.features.auth.domain.repository.AuthRepository
import com.arghamnegargroup.core.features.item.data.remote.dto.request.SearchRequest
import com.arghamnegargroup.core.features.item.domain.model.Item
import com.arghamnegargroup.core.features.item.domain.repository.ItemRepository
import com.arghamnegargroup.core.features.stock.domain.repository.StockRepository

class Search(
    private val repository: ItemRepository,
    private val stockRepository: StockRepository,
    private val authRepository: AuthRepository,
) {
    suspend operator fun invoke(query: String): Result<List<Item>> {
        return try {
            val items = repository.search(SearchRequest(query,
                authRepository.getUser()?.userID,
                stockRepository.getCurrentStock()?.id))
            Result.success(items)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}