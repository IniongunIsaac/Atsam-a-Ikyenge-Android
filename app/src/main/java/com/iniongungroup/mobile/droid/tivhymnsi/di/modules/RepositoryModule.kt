package com.iniongungroup.mobile.droid.tivhymnsi.di.modules

import com.iniongungroup.mobile.droid.tivhymnsi.di.scopes.AppScope
import com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.repoimpl.favorite.FavoritesRepoImpl
import com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.repoimpl.fontstyle.FontStyleRepoImpl
import com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.repoimpl.settings.SettingsRepoImpl
import com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.repoimpl.songs.SongsRepoImpl
import com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.repoimpl.theme.ThemeRepoImpl
import com.iniongungroup.mobile.droid.tivhymnsi.preferences.repoimpl.PreferenceRepoImpl
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.favorites.IFavoritesRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.fontstyle.IFontStyleRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.settings.ISettingsRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.songs.ISongsRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.theme.IThemeRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.preferences.IPreferencesRepo
import dagger.Binds
import dagger.Module

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Module
abstract class RepositoryModule {

    @Binds
    @AppScope
    abstract fun bindPreferencesRepo(preference: PreferenceRepoImpl): IPreferencesRepo

    @Binds
    @AppScope
    abstract fun bindSongsRepo(repo: SongsRepoImpl): ISongsRepo

    @Binds
    @AppScope
    abstract fun bindFavoritesRepo(repo: FavoritesRepoImpl): IFavoritesRepo

    @Binds
    @AppScope
    abstract fun bindSettingsRepo(repo: SettingsRepoImpl): ISettingsRepo

    @Binds
    @AppScope
    abstract fun bindThemeRepo(repo: ThemeRepoImpl): IThemeRepo

    @Binds
    @AppScope
    abstract fun bindFontStyleRepo(repo: FontStyleRepoImpl): IFontStyleRepo

}