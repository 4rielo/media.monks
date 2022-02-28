package com.scarafia.mediamonks.application.repository

import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel

interface TypicodeRepository {

    suspend fun getAlbumsList(): List<AlbumModel>

    suspend fun getPhotoList(): List<PhotosModel>
}