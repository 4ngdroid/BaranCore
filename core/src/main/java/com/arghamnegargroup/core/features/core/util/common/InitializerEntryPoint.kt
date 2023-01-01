package com.arghamnegargroup.core.features.core.util.common

import android.content.Context
import com.arghamnegargroup.core.features.core.util.initializer.WorkerInitializer
//import com.arghamnegargroup.core.features.core.util.initializer.WorkManagerInitializer
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface InitializerEntryPoint {

    //    fun inject(initializer: WorkManagerInitializer)
    fun inject(initializer: WorkerInitializer)

    companion object {
        fun resolve(context: Context): InitializerEntryPoint {
            val appContext = context.applicationContext ?: throw IllegalStateException()
            return EntryPointAccessors.fromApplication(
                appContext,
                InitializerEntryPoint::class.java
            )
        }
    }
}