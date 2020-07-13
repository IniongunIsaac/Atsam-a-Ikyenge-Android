package com.iniongungroup.mobile.droid.tivhymnsi.di.modules

import android.content.Context
import com.google.gson.GsonBuilder
import com.iniongungroup.mobile.droid.tivhymnsi.TivHymnsIApplication
import com.iniongungroup.mobile.droid.tivhymnsi.common.rxscheduler.AppSchedulerProvider
import com.iniongungroup.mobile.droid.tivhymnsi.common.rxscheduler.SchedulerProvider
import com.iniongungroup.mobile.droid.tivhymnsi.di.scopes.AppScope
import com.iniongungroup.mobile.droid.tivhymnsi.utils.AppConstants
import dagger.Module
import dagger.Provides

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideContext(tivHymnsIApp: TivHymnsIApplication): Context = tivHymnsIApp

    @Provides
    @AppScope
    fun provideGson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Provides
    @AppScope
    fun provideSharedPreference(context: Context) = context.getSharedPreferences(AppConstants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    @Provides
    @AppScope
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}