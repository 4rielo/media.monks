package com.scarafia.mediamonks.presentation.screens.splash

import android.R
import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.scarafia.mediamonks.databinding.ActivitySplashBinding
import com.scarafia.mediamonks.presentation.screens.homescreen.HomeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class SplashActivity: AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val splashViewModel: SplashViewModel by viewModel()
    private lateinit var homeIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        val animationView = binding.laLootieAnimation
        homeIntent = Intent(this, HomeActivity::class.java)

        animationView
            .addAnimatorListener(object : Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                finish()
                startActivity(intent)
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })

        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        setObservers()
    }

    private fun setObservers() {
        observeSafetyTimeout()
    }

    private fun observeSafetyTimeout(){
        splashViewModel.safeTimeout.observe(this){
            if(it) {
                finish()
                startActivity(homeIntent)
            }
        }
    }

}