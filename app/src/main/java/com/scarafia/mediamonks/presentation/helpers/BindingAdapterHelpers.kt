package com.scarafia.mediamonks.presentation.helpers

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.scarafia.mediamonks.R

@BindingAdapter("android:loadImageWithGlideFromUrl")
fun loadImageFromUrl(imageView: AppCompatImageView, url: String) {
    Glide.with(imageView.context)
        .load(url)
        .placeholder(R.drawable.ic_monks_logo_inverted)
        .error(R.drawable.ic_baseline_image_not_supported)
        .centerCrop()
        .into(imageView)
}
