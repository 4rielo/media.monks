package com.scarafia.mediamonks.presentation.screens.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.scarafia.mediamonks.databinding.ActivityHomeBinding
import com.scarafia.mediamonks.presentation.screens.albumslist.AlbumsFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    private lateinit var fragmentAdapter: ViewPagerAdapter

    private lateinit var albumsFragment: AlbumsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        fragmentAdapter = ViewPagerAdapter(this)

        binding.apply {
            viewModel = homeViewModel
            vpFragmentViewer.adapter = fragmentAdapter
        }

        albumsFragment = AlbumsFragment()

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        fragmentAdapter.setFragmentList(listOf(albumsFragment))
    }

}