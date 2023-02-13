package com.example.practice.network

import com.squareup.moshi.Json

data class Content (
    val id : String,
    @Json(name = "img_src") val imgSrcUrl:String
        )