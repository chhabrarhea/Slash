package com.example.slash.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.slash.database.models.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)

abstract class ArticleDatabase : RoomDatabase() {
    abstract val getDao:ArticleDao?
}
