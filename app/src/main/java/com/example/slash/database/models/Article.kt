package com.example.slash.database.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cachedArticles")
data class Article (
    @Embedded
    val source: Source,
    val author:String,
    val title:String,
    @PrimaryKey
    val url:String,
    val urlToImage:String,
    val publishedAt:String,
    val content:String?
    )