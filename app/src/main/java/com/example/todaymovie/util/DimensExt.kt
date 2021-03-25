package com.example.todaymovie.util

import android.content.res.Resources

//convert px to dp
val Int.dp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

//convert dp to px
val Int.px: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()