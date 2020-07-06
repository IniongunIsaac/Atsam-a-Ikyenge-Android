package com.iniongungroup.mobile.droid.atsamaikyenge.preferences.repoimpl

import android.content.SharedPreferences
import com.google.gson.Gson
import com.iniongungroup.mobile.droid.atsamaikyenge.common.theme.ThemeConstants
import com.iniongungroup.mobile.droid.atsamaikyenge.preferences.utils.PreferenceConstants
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.preferences.IPreferencesRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class PreferenceRepoImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences,
    private val gson: Gson
): IPreferencesRepo {

    override var isDBInitialized
        get() = getPreference(PreferenceConstants.DB_INITIALIZED_KEY, false)
        set(value) = setPreference(PreferenceConstants.DB_INITIALIZED_KEY, value)

    override var currentTheme: String
        get() = getPreference(PreferenceConstants.CURRENT_THEME_KEY, ThemeConstants.SYSTEM_DEFAULT.name)
        set(value) = setPreference(PreferenceConstants.CURRENT_THEME_KEY, value)

    @Suppress("UNCHECKED_CAST")
    @Synchronized
    fun <T> getPreference(key: String, default: T): T = with(sharedPreferences) {
        val res: Any = when (default) {
            is Long -> getLong(key, default)
            is String -> getString(key, default)
            is Int -> getInt(key, default)
            is Boolean -> getBoolean(key, default)
            is Float -> getFloat(key, default)
            else -> throw IllegalArgumentException(PreferenceConstants.CANT_BE_RETRIEVED_FROM_PREFERENCES_MESSAGE)
        }!!

        res as T
    }

    @Synchronized
    fun <T> setPreference(key: String, value: T) = with(sharedPreferences.edit()) {
        when (value) {
            is Long -> putLong(key, value)
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Boolean -> putBoolean(key, value)
            is Float -> putFloat(key, value)
            else -> throw IllegalArgumentException(PreferenceConstants.CANT_BE_SAVED_TO_PREFERENCES_MESSAGE.replace("value", value.toString(), true))
        }.apply()
    }

}