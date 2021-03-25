package com.example.todaymovie.util

private const val BASE_IMAGE_URL = "https://image.tmdb.org/t/p/"
private const val ORIGIN_IMAGE_SIZE = "original"
private const val W780_IMAGE_SIZE = "w780"
private const val W1280_IMAGE_SIZE = "w1280"

fun getPosterPath(imagePath: String?): String?{
    imagePath?.let {
        return "$BASE_IMAGE_URL${ORIGIN_IMAGE_SIZE}${imagePath}"
    }?: return null
}

fun getBackDropPath(imagePath: String?): String?{
    imagePath?.let {
        return "$BASE_IMAGE_URL${W1280_IMAGE_SIZE}${imagePath}"
    }?: return null
}