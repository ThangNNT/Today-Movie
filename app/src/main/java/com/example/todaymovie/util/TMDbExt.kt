package com.example.todaymovie.util

const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"
const val IMAGE_SIZE = "original"

fun getPosterPath(imagePath: String?): String?{
    imagePath?.let {
        return "$BASE_IMAGE_URL${IMAGE_SIZE}${imagePath}"
    }?: return null
}