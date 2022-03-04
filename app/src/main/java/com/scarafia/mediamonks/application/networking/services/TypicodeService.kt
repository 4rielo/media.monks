package com.scarafia.mediamonks.application.networking.services

import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import retrofit2.http.GET

interface TypicodeService {
    @GET("albums")
    suspend fun getAlbumsList(): List<AlbumModel>

    @GET("photos")
    suspend fun getPhotoList(): List<PhotosModel>
}