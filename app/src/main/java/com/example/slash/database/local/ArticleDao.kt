package com.example.slash.database.local

import androidx.room.*
import com.example.slash.database.models.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles:List<Article>)

    @Query("Delete From cachedArticles")
    suspend fun clearCache()

    @Query("Select * from cachedArticles")
     fun getCachedArticles():Flow<List<Article>>

}