package com.iniongungroup.mobile.droid.tivhymnsi.di.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iniongungroup.mobile.droid.tivhymnsi.common.base.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Isaac Iniongun on 13/07/2020.
 * For Tiv Hymns I project.
 */

class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out BaseViewModel>, Provider<BaseViewModel>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val found = creators.entries.find { modelClass.isAssignableFrom(it.key) }
        val creator = found?.value
            ?: throw IllegalArgumentException("Unknown model class $modelClass")
        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}