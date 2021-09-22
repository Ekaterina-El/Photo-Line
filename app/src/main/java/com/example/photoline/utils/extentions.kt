package com.example.photoline.utils

import android.widget.ImageView
import com.example.photoline.R
import com.squareup.picasso.Picasso

fun ImageView.downloadImageAndSet(url: String) {
    val uUrl = if (url.isEmpty()) "empty" else url
    val picasso = Picasso.get()
    picasso
        .load(uUrl)
        .placeholder(R.drawable.photo_loader)
        .into(this)
}
