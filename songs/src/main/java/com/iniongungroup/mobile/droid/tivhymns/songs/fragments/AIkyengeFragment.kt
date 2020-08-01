package com.iniongungroup.mobile.droid.tivhymns.songs.fragments

import com.iniongungroup.mobile.droid.tivhymns.common.base.BaseFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.BR
import com.iniongungroup.mobile.droid.tivhymns.songs.R
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivity
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivityViewModel
import com.iniongungroup.mobile.droid.tivhymns.songs.databinding.AIkyengeFragmentBinding

class AIkyengeFragment: BaseFragment<AIkyengeFragmentBinding, SongsActivityViewModel>() {
    
    private val songsActivityViewModel by lazy { (requireActivity() as SongsActivity).songsActivityViewModel }
    private lateinit var binding: AIkyengeFragmentBinding

    override fun getViewModel() = songsActivityViewModel

    override fun getLayoutId() = R.layout.a_ikyenge_fragment

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutBinding(binding: AIkyengeFragmentBinding) { this.binding = binding }
}