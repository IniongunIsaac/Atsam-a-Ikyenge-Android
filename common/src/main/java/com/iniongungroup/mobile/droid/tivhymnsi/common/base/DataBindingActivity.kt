package com.iniongungroup.mobile.droid.tivhymnsi.common.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by Isaac Iniongun on 10/07/2020.
 * For Atsam a Ikyenge project.
 */

abstract class DataBindingActivity : AppCompatActivity() {

    protected inline fun <reified T : ViewDataBinding> binding(
        @LayoutRes resId: Int
    ): Lazy<T> = lazy { DataBindingUtil.setContentView<T>(this, resId) }
}