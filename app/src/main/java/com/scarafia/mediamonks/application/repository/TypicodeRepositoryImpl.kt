package com.scarafia.mediamonks.application.repository

import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.application.networking.services.TypicodeService

class TypicodeRepositoryImpl(private val service: TypicodeService): TypicodeRepository {

    override suspend fun getAlbumsList(): List<AlbumModel> = service.getAlbumsList()

    override suspend fun getPhotoList(): List<PhotosModel> = service.getPhotoList()
}