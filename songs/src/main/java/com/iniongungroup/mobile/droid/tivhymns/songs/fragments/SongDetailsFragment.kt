package com.iniongungroup.mobile.droid.tivhymns.songs.fragments

import com.iniongungroup.mobile.droid.tivhymns.common.base.BaseFragment
import com.iniongungroup.mobile.droid.tivhymns.songs.BR
import com.iniongungroup.mobile.droid.tivhymns.songs.R
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivity
import com.iniongungroup.mobile.droid.tivhymns.songs.SongsActivityViewModel
import com.iniongungroup.mobile.droid.tivhymns.songs.databinding.SongDetailsFragmentBinding

class SongDetailsFragment: BaseFragment<SongDetailsFragmentBinding, SongsActivityViewModel>() {

    private val songsActivityViewModel by lazy { (requireActivity() as SongsActivity).songsActivityViewModel }
    private lateinit var binding: SongDetailsFragmentBinding

    override fun getViewModel() = songsActivityViewModel

    override fun getLayoutId() = R.layout.song_details_fragment

    override fun getBindingVariable() = BR.viewModel

    override fun getLayoutBinding(binding: SongDetailsFragmentBinding) { this.binding = binding }
}