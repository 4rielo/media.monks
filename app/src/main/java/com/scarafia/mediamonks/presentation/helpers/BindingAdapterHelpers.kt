package com.scarafia.mediamonks.presentation.helpers

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.scarafia.mediamonks.R


@BindingAdapter("android:loadImageWithGlideFromUrl")
fun loadImageFromUrl(imageView: AppCompatImageView, url: String) {
    val newUrl = GlideUrl(url, LazyHeaders.Builder()
            .addHeader("User-Agent", "your-user-agent")
            .build())

    Glide.with(imageView.context)
        .load(newUrl)
        .placeholder(R.drawable.ic_monks_logo_inverted)
        .error(R.drawable.ic_baseline_image_not_supported)
        .centerInside()
        .into(imageView)
}
