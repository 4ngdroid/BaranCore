package com.arghamnegargroup.core.features.core.data.remote.interceptor

import com.arghamnegargroup.core.features.core.util.common.ConvertToLatin
import com.arghamnegargroup.core.features.core.util.ext.bodyToString
import com.arghamnegargroup.core.features.core.util.ext.toLatinDigits
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import okio.Buffer
import retrofit2.Invocation

class LatinDigitInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val invocation = chain.request().tag(Invocation::class.java)
            ?: return chain.proceed(chain.request())

        val shouldAttachAuthHeader = invocation
            .method()
            .annotations
            .any { it.annotationClass == ConvertToLatin::class }

        return if (shouldAttachAuthHeader) {
            val request = chain.request()
            chain.proceed(
                when (request.method) {
                    "GET" -> {
                        val url = request.url
                        request.newBuilder().url(url.newBuilder().build()).build()
                    }
                    "POST" -> {
                        val body = request.body
                        request.newBuilder().post(body.bodyToString().toLatinDigits().toRequestBody(body?.contentType())).build()
                    }
                    else -> request
                }
            )
        } else chain.proceed(chain.request())
    }
}