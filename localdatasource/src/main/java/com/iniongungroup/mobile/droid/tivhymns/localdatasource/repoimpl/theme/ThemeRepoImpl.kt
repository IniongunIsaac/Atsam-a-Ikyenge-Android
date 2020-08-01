package com.iniongungroup.mobile.droid.tivhymns.localdatasource.repoimpl.theme

import com.iniongungroup.mobile.droid.tivhymns.entities.Theme
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.dao.ThemeDao
import com.iniongungroup.mobile.droid.tivhymns.repository.localdatasource.theme.IThemeRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class ThemeRepoImpl @Inject constructor(
    private val themeDao: ThemeDao
): IThemeRepo {

    override fun getAllThemes() = themeDao.getAllThemes()

    override fun getThemeById(themeId: String) = themeDao.getThemeById(themeId)

    override fun insertThemes(themes: List<Theme>) = themeDao.insertThemes(themes)

    override fun deleteThemes(themes: List<Theme>) = themeDao.deleteThemes(themes)

    override fun getThemeByName(name: String) = themeDao.getThemeByName(name)

    override fun deleteThemes() = themeDao.deleteThemes()

}