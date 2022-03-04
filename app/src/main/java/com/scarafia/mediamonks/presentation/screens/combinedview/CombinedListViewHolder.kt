package com.scarafia.mediamonks.presentation.screens.combinedview

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.R
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.databinding.ListItemCombinedAlbumPhotoBinding
import com.scarafia.mediamonks.presentation.screens.photoslist.PhotoListAdapter


class CombinedListViewHolder(private val binding: ListItemCombinedAlbumPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(album: AlbumModel, photos: List<PhotosModel>, position: Int,currentContext: Context) {
        val rvAdapter = PhotoListAdapter {}
        binding.apply {
            if(position.rem(2).equals(0)) {
                clBackground.background = getDrawable(currentContext, R.color.light_gray)
            }
            tvAlbumTitle.text = album.title
            rvPhotoList.adapter = rvAdapter
            rvPhotoList.layoutManager = GridLayoutManager(currentContext,4)
            rvAdapter.updateRecycler(photos)
        }
    }
}
