package com.arghamnegargroup.core.features.dictionary.domain.usecase

import com.arghamnegargroup.core.features.dictionary.data.remote.request.DictionaryRequest
import com.arghamnegargroup.core.features.dictionary.domain.model.Dictionary
import com.arghamnegargroup.core.features.dictionary.domain.repository.DictionaryRepository

class GetDictionaries(
    private val repository: DictionaryRepository,
) {

    suspend operator fun invoke(type: Dictionary.Type): Result<List<Dictionary>> {
        return try {
            val dictionaries = repository.getDictionaries(DictionaryRequest(type.code))
            Result.success(dictionaries)
        } catch (e: Throwable) {
            Result.failure(e)
        }
    }
}