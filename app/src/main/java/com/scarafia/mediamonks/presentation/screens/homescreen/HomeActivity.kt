package com.scarafia.mediamonks.presentation.screens.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayoutMediator
import com.scarafia.mediamonks.databinding.ActivityHomeBinding
import com.scarafia.mediamonks.presentation.screens.albumslist.AlbumsFragment
import com.scarafia.mediamonks.presentation.screens.photoslist.PhotosFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var fragmentAdapter: ViewPagerAdapter

    private lateinit var albumsFragment: AlbumsFragment
    private lateinit var photosFragment: PhotosFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        fragmentAdapter = ViewPagerAdapter(this)

        albumsFragment = AlbumsFragment()
        photosFragment = PhotosFragment()
        fragmentAdapter.setFragmentList(listOf(albumsFragment, photosFragment))

        binding.apply {
            viewModel = homeViewModel
            vpFragmentViewer.adapter = fragmentAdapter

            TabLayoutMediator(tbTabLayout, vpFragmentViewer) { tab, position ->
                tab.text = if(position == 0) {"Albums"} else {"Photos"}
            }.attach()
        }

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    private fun setObservers() {
        observeToast()
    }

    private fun observeToast(){
        homeViewModel.toastMsg.observe(this){
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
    }

}