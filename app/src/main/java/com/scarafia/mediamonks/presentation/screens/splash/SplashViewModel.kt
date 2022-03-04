package com.scarafia.mediamonks.presentation.screens.splash


import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.scarafia.mediamonks.application.ApplicationConstants
import com.scarafia.mediamonks.presentation.helpers.BaseViewModel
class SplashViewModel: BaseViewModel() {

    private val _safeTimeout = MutableLiveData<Boolean>()
    val safeTimeout: LiveData<Boolean> = _safeTimeout

    init {
        //This is a safety timeout, in case there's a problem with the animation.
        object : CountDownTimer(
            ApplicationConstants.SPLASH_SAFE_TIMEOUT_DURATION,
            ApplicationConstants.SPLASH_SAFE_TIMEOUT_STEP
        ) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                _safeTimeout.value = true
            }
        }.start()
    }

}