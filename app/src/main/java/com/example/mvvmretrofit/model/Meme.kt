package com.example.mvvmretrofit.model

import android.icu.text.DateTimePatternGenerator.DisplayWidth

data class Meme(
    val box_count: Int,
    val height: Int,
    val width: Int,
    val id: String,
    val name: String,
    val url: String,
)
