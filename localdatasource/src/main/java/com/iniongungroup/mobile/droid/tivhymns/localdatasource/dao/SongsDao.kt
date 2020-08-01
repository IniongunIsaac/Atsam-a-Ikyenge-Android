package com.iniongungroup.mobile.droid.tivhymns.localdatasource.dao

import androidx.room.*
import com.iniongungroup.mobile.droid.tivhymns.entities.Song
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

@Dao
interface SongsDao {

    @Query("select * from Song")
    fun getAllSongs(): Observable<List<Song>>

    @Query("select * from Song where id = :songId limit 1")
    fun getSongById(songId: String): Single<Song>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(vararg songs: Song): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSongs(songs: List<Song>): Completable

    @Delete
    fun deleteSongs(songs: List<Song>): Completable

    @Query("delete from Song")
    fun deleteSongs(): Completable
    
}