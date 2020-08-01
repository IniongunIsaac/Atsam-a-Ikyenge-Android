package com.iniongungroup.mobile.droid.tivhymns.common.navigation

import android.content.Context
import android.content.Intent
import com.iniongungroup.mobile.droid.tivhymns.common.BuildConfig

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

object AppActivityNavCommands {

    fun getHomeActivityIntent(context: Context) = navigationIntent(context, BuildConfig.SONGS_NAV_INTENT)

    private fun navigationIntent(context: Context, navAction: String) = Intent(navAction).setPackage(context.packageName)

}