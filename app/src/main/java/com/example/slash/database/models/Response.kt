package com.example.slash.database.models

import com.google.gson.annotations.SerializedName

data class Response (
    val status:String,
    val totalResults:Int,
    val articles:List<Article>)