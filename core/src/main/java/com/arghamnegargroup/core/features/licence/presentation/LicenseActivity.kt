package com.arghamnegargroup.core.features.licence.presentation

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.arghamnegargroup.core.R
import com.arghamnegargroup.core.features.core.util.common.CoreConstants.TAG
import kotlin.system.exitProcess

class LicenseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)
    }

    override fun onBackPressed() {}
}