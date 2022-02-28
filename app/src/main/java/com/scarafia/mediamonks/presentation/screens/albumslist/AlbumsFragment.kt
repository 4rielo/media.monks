package com.scarafia.mediamonks.presentation.screens.albumslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.scarafia.mediamonks.databinding.FragmentAlbumsBinding
import com.scarafia.mediamonks.presentation.screens.homescreen.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class AlbumsFragment : Fragment() {
    private lateinit var binding: FragmentAlbumsBinding
    private val homeViewModel: HomeViewModel by sharedViewModel()

    private lateinit var albumListAdapter: AlbumListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumsBinding.inflate(layoutInflater)
        albumListAdapter = AlbumListAdapter()

        binding.apply {
            viewModel = homeViewModel
            rvAlbumList.adapter = albumListAdapter
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    private fun setObservers() {
        observeAlbumList()
    }

    private fun observeAlbumList() {
        homeViewModel.albumModelList.observe(this){
            albumListAdapter.updateRecycler(it)
        }
    }
}