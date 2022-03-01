package com.scarafia.mediamonks.presentation.screens.photoslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.R
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.databinding.ListItemAlbumBinding
import com.scarafia.mediamonks.databinding.ListItemPhotoBinding
import com.scarafia.mediamonks.presentation.screens.albumslist.AlbumListViewHolder

class PhotoListAdapter(private val photoClickListener: (photo: PhotosModel) -> Unit): RecyclerView.Adapter<PhotosListViewHolder>() {

    private var photosList: List<PhotosModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosListViewHolder {
        val binding: ListItemPhotoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_photo,
            parent,
            false
        )
        return PhotosListViewHolder(binding)
    }

    override fun getItemCount(): Int = photosList.size

    override fun onBindViewHolder(holder: PhotosListViewHolder, position: Int) {
        holder.bind(photosList[position], photoClickListener = photoClickListener)
    }

    fun updateRecycler(photosList: List<PhotosModel>) {
        this.photosList = photosList
        notifyDataSetChanged()
    }
}