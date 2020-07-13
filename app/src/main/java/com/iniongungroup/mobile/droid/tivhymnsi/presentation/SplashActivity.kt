package com.iniongungroup.mobile.droid.tivhymnsi.presentation

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.iniongungroup.mobile.droid.tivhymnsi.R
import com.iniongungroup.mobile.droid.tivhymnsi.BR
import com.iniongungroup.mobile.droid.tivhymnsi.common.base.BaseActivity
import com.iniongungroup.mobile.droid.tivhymnsi.common.livedataevent.LiveDataEventObserver
import com.iniongungroup.mobile.droid.tivhymnsi.common.state.AppState.*
import com.iniongungroup.mobile.droid.tivhymnsi.databinding.SplashActivityBinding
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

class SplashActivity : BaseActivity<SplashActivityBinding, SplashActivityViewModel>() {

    @Inject lateinit var splashActivityViewModel: SplashActivityViewModel

    private lateinit var binding: SplashActivityBinding

    override fun getLayoutId() = R.layout.splash_activity

    override fun getViewModel() = splashActivityViewModel

    override fun getBindingVariable() = BR.viewModel

    override fun getBinding(binding: SplashActivityBinding) { this.binding = binding }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideStatusAndNavigationBar()

        observeStartHomeActivityLiveData()

    }


    override fun setNotificationObserver() {
        splashActivityViewModel.notificationLiveData.observe(this, LiveDataEventObserver {

            when (it.state) {

                FAILED -> {
                    dismissLoadingDialog()
                    it.message?.let { message ->
                        showMessage(currentFocus!!, message, isError = true)
                    }
                }

                WARNING -> {
                    dismissLoadingDialog()
                    it.message?.let { message ->
                        showMessage(currentFocus!!, message, isWarning = true)
                    }

                }

                LOADING -> {
                    showLoadingDialog()
                }

                SUCCESS -> {
                    dismissLoadingDialog()
                    it.message?.let { message ->
                        showMessage(currentFocus!!, message)
                    }

                    startHomeActivity()

                }

            }

        })
    }

    private fun startHomeActivity() {
        //navigate to reader section of the app
        //startActivity(AppActivityNavCommands.getHomeActivityIntent(this))
        //remove splash activity from backstack
        //finish()
    }

    private fun observeStartHomeActivityLiveData() {
        splashActivityViewModel.startHomeLiveData.observe(this, LiveDataEventObserver {
            if (it) {
                dismissLoadingDialog()
                Timer().schedule(3000) {
                    startHomeActivity()
                }
            }
        })
    }

    override fun showLoadingDialog() {
        with(binding) {
            setupProgressGroup.visibility = VISIBLE
            copyrightVersionTextView.visibility = GONE
        }

    }

    override fun dismissLoadingDialog() {
        with(binding) {
            setupProgressGroup.visibility = GONE
            progressBar.visibility = GONE
            setupInProgressTextView.visibility = GONE
            copyrightVersionTextView.visibility = VISIBLE
        }
    }

}