package com.iniongungroup.mobile.droid.tivhymns.di.component

import com.iniongungroup.mobile.droid.tivhymns.TivHymnsApplication
import com.iniongungroup.mobile.droid.tivhymns.di.modules.*
import com.iniongungroup.mobile.droid.tivhymns.di.scopes.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Isaac Iniongun on 13/07/2020.
 * For Tiv Hymns I project.
 */

@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        LocalDataSourceModule::class,
        RepositoryModule::class,
        ViewModelsModule::class,
        AppActivityBindingModule::class,
        AppFragmentBindingModule::class
    ]
)
@AppScope
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(tivHymnsApp: TivHymnsApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindAppInstance(tivHymnsApp: TivHymnsApplication): Builder

        fun buildAppComponent(): AppComponent

    }

}