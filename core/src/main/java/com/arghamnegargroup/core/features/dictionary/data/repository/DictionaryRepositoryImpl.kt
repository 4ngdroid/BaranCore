package com.arghamnegargroup.core.features.dictionary.data.repository

import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.Endpoints
import com.arghamnegargroup.core.features.dictionary.data.remote.request.DictionaryRequest
import com.arghamnegargroup.core.features.dictionary.domain.model.Dictionary
import com.arghamnegargroup.core.features.dictionary.domain.repository.DictionaryRepository

class DictionaryRepositoryImpl(
    private val api: BaranApi,
    private val connectionRepository: ConnectionRepository,
) : DictionaryRepository {

    override suspend fun getDictionaries(request: DictionaryRequest): List<Dictionary> {
        return api.getDictionary(connectionRepository.getUrl(Endpoints.GET_DICTIONARY), request).result ?: emptyList()
    }

}