package com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.settings

import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Setting
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.dao.SettingsDao
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.settings.ISettingsRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class SettingsRepoImpl @Inject constructor(
    private val settingsDao: SettingsDao
): ISettingsRepo {

    override fun getAllSettings() = settingsDao.getAllSettings()

    override fun getSettingById(settingId: String) = settingsDao.getSettingById(settingId)

    override fun insertSettings(settings: List<Setting>) = settingsDao.insertSettings(settings)

    override fun deleteSettings(settings: List<Setting>) = settingsDao.deleteSettings(settings)

    override fun updateSettings(setting: Setting) = settingsDao.updateSettings(setting)

    override fun deleteSettings() = settingsDao.deleteSettings()
}