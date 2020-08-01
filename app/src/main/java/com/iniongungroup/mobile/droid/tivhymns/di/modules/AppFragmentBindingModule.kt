package com.iniongungroup.mobile.droid.tivhymns.di.modules

import com.iniongungroup.mobile.droid.tivhymns.di.scopes.PerFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.fragments.AIkyengeFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.fragments.AVesenFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.fragments.SettingsFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.fragments.SongDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Isaac Iniongun on 13/07/2020.
 * For Tiv Hymns I project.
 */

@Module
abstract class AppFragmentBindingModule {

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindAIKyengeFragment(): AIkyengeFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindAVesenFragment(): AVesenFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindSettingsFragment(): SettingsFragment

    @PerFragment
    @ContributesAndroidInjector
    internal abstract fun bindSongDetailsFragment(): SongDetailsFragment

}