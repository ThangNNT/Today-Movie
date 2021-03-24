package com.example.todaymovie.util.binding_adapter

import android.util.Log
import android.widget.RatingBar
import androidx.databinding.BindingAdapter

@BindingAdapter("ratingAverage")
fun setRatingAverage(view: RatingBar, rate: Float?){
    rate?.let {
        Log.d("AAAAAA", it.toString())
        val rating = it/2
        view.rating = rating
        Log.d("AAAAAA", "rating: "+view.rating)
    }?: run {
        view.rating = 0F
    }
}