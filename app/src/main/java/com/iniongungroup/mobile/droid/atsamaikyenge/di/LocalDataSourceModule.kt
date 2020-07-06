package com.iniongungroup.mobile.droid.atsamaikyenge.di

import android.content.Context
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.database.AppDatabase
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
object LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) = AppDatabase(context)

    @Singleton
    @Provides
    fun provideSongsDao(db: AppDatabase) = db.songsDao()

    @Singleton
    @Provides
    fun provideSettingsDao(db: AppDatabase) = db.settingsDao()

    @Singleton
    @Provides
    fun provideThemesDao(db: AppDatabase) = db.themesDao()

    @Singleton
    @Provides
    fun provideFavoritesDao(db: AppDatabase) = db.favoritesDao()

    @Singleton
    @Provides
    fun provideFontStylesDao(db: AppDatabase) = db.fontStylesDao()

}