package com.iniongungroup.mobile.droid.atsamaikyenge.di

import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.favorite.FavoritesRepoImpl
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.fontstyle.FontStyleRepoImpl
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.settings.SettingsRepoImpl
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.songs.SongsRepoImpl
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.theme.ThemeRepoImpl
import com.iniongungroup.mobile.droid.atsamaikyenge.preferences.repoimpl.PreferenceRepoImpl
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.favorites.IFavoritesRepo
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.fontstyle.IFontStyleRepo
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.settings.ISettingsRepo
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.songs.ISongsRepo
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.theme.IThemeRepo
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.preferences.IPreferencesRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindPreferencesRepo(preference: PreferenceRepoImpl): IPreferencesRepo

    @Singleton
    @Binds
    abstract fun bindSongsRepo(repo: SongsRepoImpl): ISongsRepo

    @Singleton
    @Binds
    abstract fun bindFavoritesRepo(repo: FavoritesRepoImpl): IFavoritesRepo

    @Singleton
    @Binds
    abstract fun bindSettingsRepo(repo: SettingsRepoImpl): ISettingsRepo

    @Singleton
    @Binds
    abstract fun bindThemeRepo(repo: ThemeRepoImpl): IThemeRepo

    @Singleton
    @Binds
    abstract fun bindFontStyleRepo(repo: FontStyleRepoImpl): IFontStyleRepo

}