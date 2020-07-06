package com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.repoimpl.songs

import com.iniongungroup.mobile.droid.atsamaikyenge.entities.Song
import com.iniongungroup.mobile.droid.atsamaikyenge.localdatasource.dao.SongsDao
import com.iniongungroup.mobile.droid.atsamaikyenge.repository.localdatasource.songs.ISongsRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class ISongsRepoImpl @Inject constructor(
    private val songsDao: SongsDao
): ISongsRepo {

    override fun getAllSongs() = songsDao.getAllSongs()

    override fun getSongById(songId: String) = songsDao.getSongById(songId)

    override fun insertSongs(songs: List<Song>) = songsDao.insertSongs(songs)

    override fun deleteSongs(songs: List<Song>) = songsDao.deleteSongs(songs)

    override fun deleteSongs() = songsDao.deleteSongs()

}