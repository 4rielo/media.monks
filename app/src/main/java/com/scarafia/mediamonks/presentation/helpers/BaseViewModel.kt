package com.scarafia.mediamonks.presentation.helpers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel: ViewModel() {

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    private val _toastMsg = MutableLiveData<String>()
    val toastMsg: LiveData<String> = _toastMsg

    init {
        _progress.value = false
        _toastMsg.value = null
    }

    fun showToast(msg: String) {
        _toastMsg.value = msg
    }

    fun showProgress() {
        _progress.value = true
    }

    fun hideProgress() {
        _progress.value = false
    }
}