package com.scarafia.mediamonks.presentation.screens.albumslist

import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.databinding.ListItemAlbumBinding


class AlbumListViewHolder(private val binding: ListItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(album: AlbumModel) {
        binding.tvAlbumTitle.text = album.title
    }
}
