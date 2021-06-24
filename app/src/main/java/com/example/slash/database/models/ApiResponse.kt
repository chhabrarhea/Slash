package com.example.slash.database.models

data class ApiResponse (
    val status:String,
    val totalResults:Int,
    val articles:List<Article>)