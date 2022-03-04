package com.scarafia.mediamonks.presentation.screens.combinedview

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.databinding.ListItemCombinedAlbumPhotoBinding
import com.scarafia.mediamonks.presentation.screens.photoslist.PhotoListAdapter


class CombinedListViewHolder(private val binding: ListItemCombinedAlbumPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(album: AlbumModel, photos: List<PhotosModel>, currentContext: Context) {
        val rvAdapter = PhotoListAdapter {}
        binding.apply {
            tvAlbumTitle.text = album.title
            rvPhotoList.adapter = rvAdapter
            rvPhotoList.layoutManager = GridLayoutManager(currentContext,2)
            rvAdapter.updateRecycler(photos)
        }
    }
}
