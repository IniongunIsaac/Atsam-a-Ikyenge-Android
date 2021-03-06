package com.iniongungroup.mobile.droid.tivhymns.di.modules

import androidx.lifecycle.ViewModelProvider
import com.iniongungroup.mobile.droid.tivhymns.common.base.BaseViewModel
import com.iniongungroup.mobile.droid.tivhymns.di.keys.AppViewModelKey
import com.iniongungroup.mobile.droid.tivhymns.di.viewmodelfactory.ViewModelFactory
import com.iniongungroup.mobile.droid.tivhymns.presentation.SplashActivityViewModel
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Isaac Iniongun on 13/07/2020.
 * For Tiv Hymns I project.
 */

@Module
abstract class ViewModelsModule {

    @Binds
    internal abstract fun bindViewModelFactory(
        factory: ViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @AppViewModelKey(SplashActivityViewModel::class)
    abstract fun bindSplashActivityViewModel(
        viewModel: SplashActivityViewModel
    ): BaseViewModel

    @Binds
    @IntoMap
    @AppViewModelKey(SongsActivityViewModel::class)
    abstract fun bindSongsActivityViewModel(
        viewModel: SongsActivityViewModel
    ): BaseViewModel

}