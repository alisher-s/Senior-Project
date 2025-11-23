package com.example.seniorproject

import android.media.Image

data class Event(
    val imageResId: Int,
    val title: String,
    val date: String,
    val location: String,
    val price: String,
    val description: String
)
