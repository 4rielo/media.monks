package com.scarafia.mediamonks.presentation.screens.photoslist

import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.databinding.ListItemPhotoBinding


class PhotosListViewHolder(private val binding: ListItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(photo: PhotosModel, photoClickListener: (photo: PhotosModel) -> Unit ) {
        binding.photo = photo
        binding.root.setOnClickListener { photoClickListener(photo) }
    }
}
