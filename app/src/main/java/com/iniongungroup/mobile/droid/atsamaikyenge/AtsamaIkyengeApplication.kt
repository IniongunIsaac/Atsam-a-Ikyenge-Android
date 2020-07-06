package com.iniongungroup.mobile.droid.atsamaikyenge

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@HiltAndroidApp
class AtsamaIkyengeApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        AndroidThreeTen.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}