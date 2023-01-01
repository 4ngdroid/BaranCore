package com.arghamnegargroup.core.features.licence.util.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.licence.domain.usecase.ValidateLicense
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class LicenseWorker @AssistedInject constructor(
    @Assisted val appContext: Context,
    @Assisted val workerParams: WorkerParameters,
    val validateLicense: ValidateLicense
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val valid = validateLicense(appContext)
        Log.i(TAG, "doWork: isValid? $valid")
        if (valid == false) {

        }
        return Result.success()
    }

}