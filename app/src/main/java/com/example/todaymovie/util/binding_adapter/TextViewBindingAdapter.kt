package com.example.todaymovie.util.binding_adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.todaymovie.R


@BindingAdapter("ratingCount")
fun setRatingCount(view: TextView, ratingCount: Int?){
    ratingCount?.let {
        if(it>=10000){
            view.text = view.context.getString(R.string.rating_count_more_than_10000)
        }
        else view.text = String.format(view.context.getString(R.string.rating_count), it)
    }
}

@BindingAdapter("voteAverage")
fun setVoteAverage(view: TextView, average: Float?){
    average?.let {
        view.text = "${it/2}"
    }
}

