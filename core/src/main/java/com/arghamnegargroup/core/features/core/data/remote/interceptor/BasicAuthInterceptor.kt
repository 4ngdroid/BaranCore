package com.arghamnegargroup.core.features.core.data.remote.interceptor


import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class BasicAuthInterceptor(private val connectionRepository: ConnectionRepository) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .header("Authorization", connectionRepository.getCredentials()).build()
        return chain.proceed(authenticatedRequest)
    }

}