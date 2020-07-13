package com.iniongungroup.mobile.droid.tivhymnsi

import com.iniongungroup.mobile.droid.tivhymnsi.di.component.AppComponent
import com.iniongungroup.mobile.droid.tivhymnsi.di.component.DaggerAppComponent
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import timber.log.Timber

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class TivHymnsIApplication: DaggerApplication() {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent.inject(this)

        AndroidThreeTen.init(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        appComponent = DaggerAppComponent.builder().bindAppInstance(this).buildAppComponent()

        return appComponent

    }

}