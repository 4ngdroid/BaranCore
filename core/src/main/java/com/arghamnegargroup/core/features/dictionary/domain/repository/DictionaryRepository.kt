package com.arghamnegargroup.core.features.dictionary.domain.repository

import com.arghamnegargroup.core.features.dictionary.data.remote.request.DictionaryRequest
import com.arghamnegargroup.core.features.dictionary.domain.model.Dictionary

interface DictionaryRepository {

    suspend fun getDictionaries(request: DictionaryRequest): List<Dictionary>

}