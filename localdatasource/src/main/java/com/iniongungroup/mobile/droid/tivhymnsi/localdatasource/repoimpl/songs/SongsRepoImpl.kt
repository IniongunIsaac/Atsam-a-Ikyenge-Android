package com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.repoimpl.songs

import com.iniongungroup.mobile.droid.tivhymnsi.entities.Song
import com.iniongungroup.mobile.droid.tivhymnsi.localdatasource.dao.SongsDao
import com.iniongungroup.mobile.droid.tivhymnsi.repository.localdatasource.songs.ISongsRepo
import javax.inject.Inject

/**
 * Created by Isaac Iniongun on 06/07/2020.
 * For Atsam a Ikyenge project.
 */

class SongsRepoImpl @Inject constructor(
    private val songsDao: SongsDao
): ISongsRepo {

    override fun getAllSongs() = songsDao.getAllSongs()

    override fun getSongById(songId: String) = songsDao.getSongById(songId)

    override fun insertSongs(songs: List<Song>) = songsDao.insertSongs(songs)

    override fun deleteSongs(songs: List<Song>) = songsDao.deleteSongs(songs)

    override fun deleteSongs() = songsDao.deleteSongs()

}