package com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.songs

import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Song
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

interface ISongsRepo {

    fun getAllSongs(): Observable<List<Song>>

    fun getSongById(songId: String): Single<Song>

    fun insertSongs(songs: List<Song>): Completable

    fun deleteSongs(songs: List<Song>): Completable

    fun deleteSongs(): Completable

}