package com.scarafia.mediamonks.presentation.screens.homescreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.scarafia.mediamonks.application.model.AlbumModel
import com.scarafia.mediamonks.application.model.PhotosModel
import com.scarafia.mediamonks.application.repository.TypicodeRepository
import com.scarafia.mediamonks.presentation.helpers.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeViewModel(private val dataRepository: TypicodeRepository): BaseViewModel() {

    private val _albumList = MutableLiveData<List<AlbumModel>>()
    val albumModelList: LiveData<List<AlbumModel>> = _albumList

    private val _photosList = MutableLiveData<List<PhotosModel>>()
    val photosList: LiveData<List<PhotosModel>> = _photosList

    init {
        getListsResources()
    }

    private fun getListsResources() {
        viewModelScope.launch {
            showProgress()
            try {
                _albumList.value = dataRepository.getAlbumsList()
                _photosList.value = dataRepository.getPhotoList()
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
            hideProgress()
        }
    }

    private fun getAlbumsList() {
        viewModelScope.launch {
            showProgress()
            try {
                _albumList.value = dataRepository.getAlbumsList()
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
            hideProgress()
        }
    }

    private fun getPhotosList(){
        viewModelScope.launch {
            showProgress()
            try {
                _photosList.value = dataRepository.getPhotoList()
            } catch (e: Exception) {
                showToast(e.message.toString())
            }
            hideProgress()
        }
    }

    fun refreshAlbumList() {
        getAlbumsList()
    }

    fun refreshPhotoList(){
        getPhotosList()
    }
}