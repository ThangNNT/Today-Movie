package com.example.todaymovie.util.binding_adapter

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.todaymovie.R
import com.github.ybq.android.spinkit.style.Circle


@BindingAdapter("loadImage")
fun loadImage(view: ImageView, url: String?){
    val placeHolder = Circle().also {
        it.color = ContextCompat.getColor(view.context, R.color.colorOnPrimary)
    }
    Glide.with(view)
            .load(url)
            .placeholder(placeHolder)
            .into(view)
}