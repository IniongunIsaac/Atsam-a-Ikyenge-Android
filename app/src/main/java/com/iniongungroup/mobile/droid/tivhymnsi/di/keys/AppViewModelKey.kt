package com.iniongungroup.mobile.droid.tivhymnsi.di.keys

import com.iniongungroup.mobile.droid.tivhymnsi.common.base.BaseViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Created by Isaac Iniongun on 13/07/2020.
 * For Tiv Hymns I project.
 */

@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class AppViewModelKey (val value: KClass<out BaseViewModel>)