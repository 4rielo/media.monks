package com.scarafia.mediamonks.presentation.screens.albumslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.scarafia.mediamonks.R
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.databinding.ListItemAlbumBinding

class AlbumListAdapter: RecyclerView.Adapter<AlbumListViewHolder>() {

    private var albumModelList: List<AlbumModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumListViewHolder {
        val binding: ListItemAlbumBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_album,
            parent,
            false
        )
        return AlbumListViewHolder(binding)
    }

    override fun getItemCount(): Int = albumModelList.size

    override fun onBindViewHolder(holder: AlbumListViewHolder, position: Int) {
        holder.bind(albumModelList[position])
    }

    fun updateRecycler(albumModelList: List<AlbumModel>) {
        this.albumModelList = albumModelList
        notifyDataSetChanged()
    }
}