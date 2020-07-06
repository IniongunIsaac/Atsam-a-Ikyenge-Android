package com.iniongungroup.mobile.droid.atsamaikyenge.presentation

import androidx.activity.viewModels
import com.iniongungroup.mobile.droid.atsamaikyenge.BR
import com.iniongungroup.mobile.droid.atsamaikyenge.R
import com.iniongungroup.mobile.droid.atsamaikyenge.common.base.BaseActivity
import com.iniongungroup.mobile.droid.atsamaikyenge.databinding.SplashActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity<SplashActivityBinding, SplashActivityViewModel>() {

    private val splashActivityViewModel: SplashActivityViewModel by viewModels()

    private lateinit var binding: SplashActivityBinding

    override fun getLayoutId() = R.layout.splash_activity

    override fun getViewModel() = splashActivityViewModel

    override fun getBindingVariable() = BR.viewModel

    override fun getBinding(binding: SplashActivityBinding) { this.binding = binding }

}