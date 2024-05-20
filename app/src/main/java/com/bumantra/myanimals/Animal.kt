package com.bumantra.myanimals

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Animal(
    val animal: String,
    val animalDesc: String,
    val imgSrc: String
) : Parcelable
