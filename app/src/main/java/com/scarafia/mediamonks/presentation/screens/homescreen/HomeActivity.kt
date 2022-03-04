package com.scarafia.mediamonks.presentation.screens.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
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

        val fragmentList = listOf(
            AlbumsFragment.fragmentNameResource,
            PhotosFragment.fragmentNameResource
        ) to listOf(albumsFragment, photosFragment)

        binding.apply {
            viewModel = homeViewModel
            vpFragmentViewer.adapter = fragmentAdapter

            fragmentAdapter.setFragmentList(fragmentList.second)

            TabLayoutMediator(tbTabLayout, vpFragmentViewer,true,true) { tab, position ->
                tab.text = getString(fragmentList.first[position])
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
        observeProgress()
    }

    private fun observeToast() {
        homeViewModel.toastMsg.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
    }

    private fun observeProgress() {
        homeViewModel.progress.observe(this) {
            binding.loadingIndicator.isVisible = it
        }
    }

}