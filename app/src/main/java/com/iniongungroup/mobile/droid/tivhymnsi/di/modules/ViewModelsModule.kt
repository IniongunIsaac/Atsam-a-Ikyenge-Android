package com.iniongungroup.mobile.droid.tivhymnsi.di.modules

import androidx.lifecycle.ViewModelProvider
import com.iniongungroup.mobile.droid.tivhymnsi.common.base.BaseViewModel
import com.iniongungroup.mobile.droid.tivhymnsi.di.keys.AppViewModelKey
import com.iniongungroup.mobile.droid.tivhymnsi.di.viewmodelfactory.ViewModelFactory
import com.iniongungroup.mobile.droid.tivhymnsi.presentation.SplashActivityViewModel
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

}