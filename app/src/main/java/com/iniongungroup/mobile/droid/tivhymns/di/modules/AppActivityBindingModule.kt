package com.iniongungroup.mobile.droid.tivhymns.di.modules

import com.iniongungroup.mobile.droid.tivhymns.di.scopes.PerActivity
import com.iniongungroup.mobile.droid.tivhymns.presentation.SplashActivity
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Isaac Iniongun on 13/07/2020.
 * For Tiv Hymns I project.
 */

@Module
abstract class AppActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindSplashActivity(): SplashActivity

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun bindSongsActivity(): SongsActivity

}