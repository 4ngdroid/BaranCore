package com.arghamnegargroup.core.features.licence.util.initializer

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.startup.Initializer
import androidx.work.*
import androidx.work.PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.core.util.initializer.WorkerInitializer
import com.arghamnegargroup.core.features.licence.presentation.LicenseActivity
import com.arghamnegargroup.core.features.licence.util.worker.LicenseWorker
import java.util.concurrent.TimeUnit

class LicenseValidatorInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Log.i(TAG, "LicenseValidatorInitializer: ${context.packageName}")
        val request = PeriodicWorkRequestBuilder<LicenseWorker>(
            1, TimeUnit.DAYS
        ).build()
        WorkManager.getInstance(context)
            .enqueueUniquePeriodicWork("LicenseWorker", ExistingPeriodicWorkPolicy.REPLACE, request)
        return
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(WorkerInitializer::class.java)
    }


}