package com.example.slash.database

import androidx.room.withTransaction
import com.example.slash.database.local.ArticleDatabase
import com.example.slash.database.remote.Service
import com.example.slash.util.networkBoundResource
import javax.inject.Inject

class Repository @Inject constructor(private val apiService: Service,private val db: ArticleDatabase) {
    private  val dao=db.getDao
    fun getArticles() = networkBoundResource(
        query = {
            dao!!.getCachedArticles()
        },
        fetch = {
            apiService.getArticles()
        },
        saveFetchResult = { response ->
            db.withTransaction {
               dao!!.clearCache()
                dao.insertArticles(response.articles)
            }
        }
    )
}