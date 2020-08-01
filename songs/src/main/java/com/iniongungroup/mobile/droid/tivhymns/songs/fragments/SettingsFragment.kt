package com.iniongungroup.mobile.droid.tivhymns.songs.fragments

import com.iniongungroup.mobile.droid.tivhymns.common.base.BaseFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.BR
import com.iniongungroup.mobile.droid.tivhymns.songs.R
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivity
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivityViewModel
import com.iniongungroup.mobile.droid.tivhymns.songs.databinding.SettingsFragmentBinding

class SettingsFragment: BaseFragment<SettingsFragmentBinding, SongsActivityViewModel>() {

    private val songsActivityViewModel by lazy { (requireActivity() as SongsActivity).songsActivityViewModel }
    private lateinit var binding: SettingsFragmentBinding

    override fun getViewModel() = songsActivityViewModel

    override fun getLayoutId() = R.layout.settings_fragment

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutBinding(binding: SettingsFragmentBinding) { this.binding = binding }
}