package com.arghamnegargroup.core.features.licence.util.initializer

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import androidx.work.*
import androidx.work.PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.core.util.initializer.WorkerInitializer
import com.arghamnegargroup.core.features.licence.util.worker.LicenseWorker
import java.util.concurrent.TimeUnit

class LicenseValidatorInitializer : Initializer<Unit> {

    override fun create(context: Context) {
        Log.i(TAG, "LicenseValidatorInitializer: ${context.packageName}")
        val request: WorkRequest =
            PeriodicWorkRequestBuilder<LicenseWorker>(
                MIN_PERIODIC_INTERVAL_MILLIS,
                TimeUnit.MILLISECONDS
            ).build()
        WorkManager.getInstance(context).enqueue(request)
        MIN_PERIODIC_INTERVAL_MILLIS
        return
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return listOf(WorkerInitializer::class.java)
    }


}