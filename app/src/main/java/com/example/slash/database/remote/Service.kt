package com.example.slash.database.remote

import com.example.slash.database.models.Response
import retrofit2.http.GET

interface Service {
    @GET("top-headlines?country=us&apiKey=${apiKey}")
    suspend fun getArticles():Response

    companion object{
        const val apiKey="f4da31b7586b481b9f9ffe4bc40aad05"
    }
}