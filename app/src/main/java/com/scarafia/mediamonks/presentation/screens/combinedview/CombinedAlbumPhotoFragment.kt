package com.scarafia.mediamonks.presentation.screens.combinedview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.scarafia.mediamonks.R
import com.scarafia.mediamonks.databinding.FragmentCombinedAlbumPhotosBinding
import com.scarafia.mediamonks.presentation.screens.homescreen.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CombinedAlbumPhotoFragment: Fragment() {
    private lateinit var binding: FragmentCombinedAlbumPhotosBinding
    private val homeViewModel: HomeViewModel by sharedViewModel()

    private lateinit var combinedListAdapter: CombinedListAdapter

    companion object{
        val fragmentNameResource = R.string.combined_list_fragment
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCombinedAlbumPhotosBinding.inflate(layoutInflater)
        combinedListAdapter = CombinedListAdapter(requireContext())

        binding.apply {

            rvCombinedList.adapter = combinedListAdapter

            swSwipeToRefresh.setOnRefreshListener {
                homeViewModel.refreshPhotoList()
            }
        }

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    private fun setObservers(){
        observeCombinedListMediatior()
    }

    private fun observeCombinedListMediatior(){
        homeViewModel.mediatorCombinedList.observe(viewLifecycleOwner) {
            combinedListAdapter.updateRecycler(it)
            binding.swSwipeToRefresh.isRefreshing = false
        }
    }
}