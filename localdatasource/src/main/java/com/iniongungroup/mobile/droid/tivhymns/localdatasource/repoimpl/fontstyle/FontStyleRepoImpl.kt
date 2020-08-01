package com.iniongungroup.mobile.droid.tivhymns.localdatasource.repoimpl.fontstyle

import com.iniongungroup.mobile.droid.tivhymns.entities.FontStyle
import com.iniongungroup.mobile.droid.tivhymns.localdatasource.dao.FontStyleDao
import com.iniongungroup.mobile.droid.tivhymns.repository.localdatasource.fontstyle.IFontStyleRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class FontStyleRepoImpl @Inject constructor(
    private val fontStyleDao: FontStyleDao
): IFontStyleRepo {

    override fun getAllFontStyles() = fontStyleDao.getAllFontStyles()

    override fun getFontStyleByName(fontStyleName: String) = fontStyleDao.getFontStyleByName(fontStyleName)

    override fun getFontStyleById(fontStyleId: String) = fontStyleDao.getFontStyleById(fontStyleId)

    override fun insertFontStyles(fontStyles: List<FontStyle>) = fontStyleDao.insertFontStyles(fontStyles)

    override fun deleteFontStyles(fontStyles: List<FontStyle>) = fontStyleDao.deleteFontStyles(fontStyles)

    override fun deleteAllFontStyles() = fontStyleDao.deleteAllFontStyles()

}