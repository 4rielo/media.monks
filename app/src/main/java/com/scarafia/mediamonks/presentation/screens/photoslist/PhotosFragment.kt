package com.scarafia.mediamonks.presentation.screens.photoslist

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.GridLayoutManager
import com.scarafia.mediamonks.R
import com.scarafia.mediamonks.databinding.DialogPhotoDetailBinding
import com.scarafia.mediamonks.databinding.FragmentPhotosBinding
import com.scarafia.mediamonks.presentation.screens.homescreen.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val homeViewModel: HomeViewModel by sharedViewModel()

    private lateinit var photoListAdapter: PhotoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotosBinding.inflate(layoutInflater)
        photoListAdapter = PhotoListAdapter { selectedPhoto ->
            val dialog = AlertDialog.Builder(activity)
            val dialogBinding = DialogPhotoDetailBinding.inflate(layoutInflater)
            dialogBinding.photoDetail = selectedPhoto
            dialog.setTitle(R.string.photo_detail)
                .setView(dialogBinding.root)
                .create()
                .show()
        }
        
        binding.apply {
            viewModel = homeViewModel
            rvPhotoList.adapter = photoListAdapter
            rvPhotoList.layoutManager = GridLayoutManager(activity,2)
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
        homeViewModel.photosList.observe(this){
            photoListAdapter.updateRecycler(it)
        }
    }
}