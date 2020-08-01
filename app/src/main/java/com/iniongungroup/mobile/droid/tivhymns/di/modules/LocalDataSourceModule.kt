package com.iniongungroup.mobile.droid.tivhymns.di.modules

import android.content.Context
import com.iniongungroup.mobile.droid.tivhymns.di.scopes.AppScope
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.database.AppDatabase
import dagger.Module
import dagger.Provides

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Module
class LocalDataSourceModule {

    @Provides
    @AppScope
    fun provideAppDatabase(context: Context) = AppDatabase(context)

    @Provides
    @AppScope
    fun provideSongsDao(db: AppDatabase) = db.songsDao()

    @Provides
    @AppScope
    fun provideSettingsDao(db: AppDatabase) = db.settingsDao()

    @Provides
    @AppScope
    fun provideThemesDao(db: AppDatabase) = db.themesDao()

    @Provides
    @AppScope
    fun provideFavoritesDao(db: AppDatabase) = db.favoritesDao()

    @Provides
    @AppScope
    fun provideFontStylesDao(db: AppDatabase) = db.fontStylesDao()

}