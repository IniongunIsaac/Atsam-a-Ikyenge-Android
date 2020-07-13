package com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.settings

import com.iniongungroup.mobile.droid.tivhymnsi.entities.Setting
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

interface ISettingsRepo {

    fun getAllSettings(): Observable<List<Setting>>

    fun getSettingById(settingId: String): Single<Setting>

    fun insertSettings(settings: List<Setting>): Completable

    fun deleteSettings(settings: List<Setting>): Completable

    fun deleteSettings(): Completable

    fun updateSettings(setting: Setting): Completable
}