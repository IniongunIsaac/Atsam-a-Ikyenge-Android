package com.iniongungroup.mobile.droid.atsamaikyenge.common.navigation

import android.content.Context
import android.content.Intent

/**
 * Created by Isaac Iniongun on 03/07/2020.
 * For Atsam a Ikyenge project.
 */

object AppActivityNavCommands {

    //fun getReferencesActivityIntent(context: Context) = navigationIntent(context, context.getString(R.string.references_activity_intent))

    private fun navigationIntent(context: Context, navAction: String) = Intent(navAction).setPackage(context.packageName)

}