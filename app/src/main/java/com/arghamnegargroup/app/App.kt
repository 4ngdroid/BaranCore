package com.arghamnegargroup.app

import android.app.Application
import android.os.Parcel
import android.os.Parcelable
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App() : Application()
