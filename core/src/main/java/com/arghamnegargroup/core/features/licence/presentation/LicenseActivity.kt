package com.arghamnegargroup.core.features.licence.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.arghamnegargroup.core.R
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import kotlin.system.exitProcess

class LicenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)
        Log.i(TAG, "onCreate:LicenseActivity")
    }

    override fun onBackPressed() {
        finishAffinity()
        exitProcess(0)
    }
}