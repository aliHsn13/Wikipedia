package com.example.wikipedia.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostItems (

            val img_url :String,
            val txtTile :String,
            val txtSubtitle :String,
            val txtDetails :String,
            val txtInsight :String

    ):Parcelable
    
