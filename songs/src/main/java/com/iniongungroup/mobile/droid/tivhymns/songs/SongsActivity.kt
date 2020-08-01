package com.iniongungroup.mobile.droid.tivhymns.songs

import com.iniongungroup.mobile.droid.tivhymns.common.base.BaseActivity
import com.iniongungroup.mobile.droid.tivhymns.songs.databinding.SongsActivityBinding
import javax.inject.Inject

class SongsActivity: BaseActivity<SongsActivityBinding, SongsActivityViewModel>() {

    @Inject lateinit var songsActivityViewModel: SongsActivityViewModel
    private lateinit var binding: SongsActivityBinding

    override fun getLayoutId() = R.layout.songs_activity

    override fun getViewModel() = songsActivityViewModel

    override fun getBindingVariable() = BR.viewModel

    override fun getBinding(binding: SongsActivityBinding) { this.binding = binding }
}