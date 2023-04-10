package com.arghamnegargroup.core.features.core.util.initializer

import android.content.Context
import androidx.startup.Initializer
import com.arghamnegargroup.core.features.core.util.common.InitializerEntryPoint

class DependencyGraphInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        InitializerEntryPoint.resolve(context)
        return
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}