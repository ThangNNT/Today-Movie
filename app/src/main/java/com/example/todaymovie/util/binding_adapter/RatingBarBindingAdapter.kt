package com.example.todaymovie.util.binding_adapter

import android.widget.RatingBar
import androidx.databinding.BindingAdapter

@BindingAdapter("ratingAverage")
fun setRatingAverage(view: RatingBar, rate: Float?){
    rate?.let {
        val rating = it/2
        view.rating = rating
    }?: run {
        view.rating = 0F
    }
}