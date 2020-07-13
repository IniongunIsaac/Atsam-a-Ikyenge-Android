package com.iniongungroup.mobile.droid.tivhymnsi.di.component

import com.iniongungroup.mobile.droid.tivhymnsi.TivHymnsIApplication
import com.iniongungroup.mobile.droid.tivhymnsi.di.modules.*
import com.iniongungroup.mobile.droid.tivhymnsi.di.scopes.AppScope
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

    fun inject(tivHymnsIApp: TivHymnsIApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindAppInstance(tivHymnsIApp: TivHymnsIApplication): Builder

        fun buildAppComponent(): AppComponent

    }

}