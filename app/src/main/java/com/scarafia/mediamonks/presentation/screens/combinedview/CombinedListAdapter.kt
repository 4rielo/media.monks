package com.scarafia.mediamonks.presentation.screens.combinedview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.R
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.databinding.ListItemCombinedAlbumPhotoBinding

class CombinedListAdapter(val currentContext: Context): RecyclerView.Adapter<CombinedListViewHolder>() {

    private var albumAndPhotosList: List<Pair<AlbumModel, List<PhotosModel>>> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CombinedListViewHolder {
        val binding: ListItemCombinedAlbumPhotoBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_combined_album_photo,
            parent,
            false
        )
        return CombinedListViewHolder(binding)
    }

    override fun getItemCount(): Int = albumAndPhotosList.size

    override fun onBindViewHolder(holder: CombinedListViewHolder, position: Int) {
        holder.bind(albumAndPhotosList[position].first, albumAndPhotosList[position].second, currentContext)
    }

    fun updateRecycler(albumAndPhotosList: List<Pair<AlbumModel, List<PhotosModel>>>) {
        this.albumAndPhotosList = albumAndPhotosList
        notifyDataSetChanged()
    }
}