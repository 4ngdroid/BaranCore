package com.arghamnegargroup.core.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.room.Room
import com.arghamnegargroup.core.BuildConfig
import com.arghamnegargroup.core.features.connectivity.domain.repository.ConnectionRepository
import com.arghamnegargroup.core.features.core.data.datasource.BaranDatabase
import com.arghamnegargroup.core.features.core.data.remote.BaranApi
import com.arghamnegargroup.core.features.core.data.remote.NetworkConstants
import com.arghamnegargroup.core.features.core.data.remote.NetworkHelper
import com.arghamnegargroup.core.features.core.data.remote.interceptor.BasicAuthInterceptor
import com.arghamnegargroup.core.features.core.data.remote.interceptor.LatinDigitInterceptor
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): BaranDatabase {
        return Room.databaseBuilder(
            app,
            BaranDatabase::class.java,
            BaranDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        connectionRepository: ConnectionRepository,
    ): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(NetworkConstants.TIMEOUT, TimeUnit.SECONDS)
        httpClient.addInterceptor(BasicAuthInterceptor(connectionRepository))
        httpClient.addInterceptor(LatinDigitInterceptor())
        httpClient.addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }
        )
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun provideBaranApi(client: OkHttpClient): BaranApi {
        try {
            return Retrofit.Builder()
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setLenient()
                            .create()
                    )
                )
                .baseUrl("http://127.0.0.1")
                .client(client)
                .build()
                .create(BaranApi::class.java)
        } catch (e: Exception) {
            Log.i(TAG, "BaranApi: ${e.stackTrace}")
            throw NullPointerException()
        }
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences("baran-core", Context.MODE_PRIVATE)


    @Provides
    @Singleton
    fun provideNetworkHelper(app: Application): NetworkHelper {
        return NetworkHelper(app)
    }

}