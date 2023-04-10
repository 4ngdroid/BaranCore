package com.arghamnegargroup.core.features.licence.util.worker

import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import com.arghamnegargroup.core.features.licence.domain.usecase.ValidateLicense
import com.arghamnegargroup.core.features.licence.presentation.LicenseActivity
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class LicenseWorker @AssistedInject constructor(
    @Assisted val appContext: Context,
    @Assisted val workerParams: WorkerParameters,
    val validateLicense: ValidateLicense
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        val valid = validateLicense()
        if (valid == false) {
            val intent = Intent(appContext, LicenseActivity::class.java)
            intent.flags = FLAG_ACTIVITY_NEW_TASK
            appContext.startActivity(intent)
        }
        return Result.success()
    }

}