package com.iniongungroup.mobile.droid.atsamaikyenge.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.iniongungroup.mobile.droid.atsamaikyenge.common.rxscheduler.AppSchedulerProvider
import com.iniongungroup.mobile.droid.atsamaikyenge.common.rxscheduler.SchedulerProvider
import com.iniongungroup.mobile.droid.atsamaikyenge.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create()

    @Singleton
    @Provides
    fun provideSharedPreference(@ApplicationContext context: Context) = context.getSharedPreferences(AppConstants.SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    @Singleton
    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}