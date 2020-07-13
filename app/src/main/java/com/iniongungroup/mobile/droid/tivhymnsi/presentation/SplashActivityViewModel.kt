package com.iniongungroup.mobile.droid.tivhymnsi.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.iniongungroup.mobile.droid.tivhymnsi.common.base.BaseViewModel
import com.iniongungroup.mobile.droid.tivhymnsi.common.livedataevent.LiveDataEvent
import com.iniongungroup.mobile.droid.tivhymnsi.common.rxscheduler.SchedulerProvider
import com.iniongungroup.mobile.droid.tivhymnsi.common.rxscheduler.subscribeOnIoObserveOnUi
import com.iniongungroup.mobile.droid.tivhymnsi.common.state.AppResult
import com.iniongungroup.mobile.droid.tivhymnsi.common.theme.ThemeConstants.*
import com.iniongungroup.mobile.droid.tivhymnsi.common.theme.ThemeHelper
import com.iniongungroup.mobile.droid.tivhymnsi.common.utils.ScreenSize.*
import com.iniongungroup.mobile.droid.tivhymnsi.common.utils.getDeviceScreenSize
import com.iniongungroup.mobile.droid.tivhymnsi.entities.FontStyle
import com.iniongungroup.mobile.droid.tivhymnsi.entities.Setting
import com.iniongungroup.mobile.droid.tivhymnsi.entities.Song
import com.iniongungroup.mobile.droid.tivhymnsi.entities.Theme
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.fontstyle.IFontStyleRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.settings.ISettingsRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.songs.ISongsRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.theme.IThemeRepo
import com.iniongungroup.mobile.droid.tivhymnsi.repository.preferences.IPreferencesRepo
import io.reactivex.Completable
import java.io.BufferedReader
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class SplashActivityViewModel @Inject constructor(
    private val context: Context,
    private val preferencesRepo: IPreferencesRepo,
    private val schedulerProvider: SchedulerProvider,
    private val settingsRepo: ISettingsRepo,
    private val fontStylesRepo: IFontStyleRepo,
    private val themesRepo: IThemeRepo,
    private val songsRepo: ISongsRepo
): BaseViewModel() {

    val x = "this viewmodel injection worked well"

    private val _startHomeLiveData = MutableLiveData<LiveDataEvent<Boolean>>()
    val startHomeLiveData = _startHomeLiveData as LiveData<LiveDataEvent<Boolean>>

    init {
        //setupDB()
    }

    private fun setupDB() {
        if (preferencesRepo.isDBInitialized) {
            applyThemeFromSavedSettings()
            _startHomeLiveData.value = LiveDataEvent(true)
        } else {
            initializeDB()
        }
    }

    private fun getSongsJsonData(): List<Song> {

        val bufferedReader: BufferedReader = context.assets.open("atsam_a_ikyenge.json").bufferedReader()
        val dataString = bufferedReader.use { it.readText() }
        val songsDataTypeToken = object : TypeToken<List<Song>>() {}.type

        return Gson().fromJson(dataString, songsDataTypeToken)
    }

    private fun initializeDB() {
        _notificationLiveData.postValue(LiveDataEvent(AppResult.loading()))
        addSetupData()
    }

    private fun addSetupData() {
        val themes = listOf(Theme(name = "SYSTEM_DEFAULT"), Theme(name = "LIGHT"), Theme(name = "DARK"), Theme(name = "BATTERY_SAVER"))

        val fontStyles = listOf(
            FontStyle(name = "montserrat.ttf"), FontStyle(name = "happy_monkey.ttf"), FontStyle(name = "metamorphous.ttf"), FontStyle(name = "roboto.ttf"),
            FontStyle(name = "comfortaa.ttf"), FontStyle(name = "amatic_sc.ttf"), FontStyle(name = "inconsolata_expanded.ttf"), FontStyle(name = "indie_flower.ttf"),
            FontStyle(name = "jost.ttf"), FontStyle(name = "lato.ttf"), FontStyle(name = "lobster.ttf"), FontStyle(name = "josefin_sans.ttf"), FontStyle(name = "merriweather.ttf"),
            FontStyle(name = "oxygen.ttf")
        )

        var fontSize = 0
        var lineSpacing = 0

        when(getDeviceScreenSize(context.resources)) {
            SMALL -> {
                fontSize = 12
                lineSpacing = 7
            }

            NORMAL, UNDEFINED -> {
                fontSize = 14
                lineSpacing = 8
            }

            LARGE -> {
                fontSize = 16
                lineSpacing = 9
            }

            XLARGE -> {
                fontSize = 18
                lineSpacing = 10
            }
        }

        val settings = listOf(Setting(fontSize = fontSize, lineSpacing = lineSpacing, fontStyle = fontStyles[0], theme = themes[0], stayAwake = true))

        compositeDisposable.add(
            Completable.mergeArray(
                themesRepo.insertThemes(themes),
                fontStylesRepo.insertFontStyles(fontStyles),
                settingsRepo.insertSettings(settings),
                songsRepo.insertSongs(getSongsJsonData())
            ).subscribeOnIoObserveOnUi(schedulerProvider, {
                preferencesRepo.isDBInitialized = true
                applyThemeFromSavedSettings()
            })
        )
    }

    private fun applyThemeFromSavedSettings() {
        compositeDisposable.add(
            settingsRepo.getAllSettings().subscribeOnIoObserveOnUi(schedulerProvider, {
                with(it.first()) {
                    val currentTheme = when(theme.name) {
                        LIGHT.name -> LIGHT
                        DARK.name -> DARK
                        BATTERY_SAVER.name -> BATTERY_SAVER
                        else -> SYSTEM_DEFAULT
                    }
                    ThemeHelper.changeTheme(currentTheme)
                    _notificationLiveData.postValue(LiveDataEvent(AppResult.success()))
                    _startHomeLiveData.value = LiveDataEvent(true)
                }
            })
        )
    }

}