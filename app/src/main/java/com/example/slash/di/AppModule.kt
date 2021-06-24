package com.example.slash.di

import android.content.Context
import androidx.room.Room
import com.example.slash.database.local.ArticleDao
import com.example.slash.database.local.ArticleDatabase
import com.example.slash.database.remote.Service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): Service{
        return retrofit.create(Service::class.java)
    }

    @Singleton
    @Provides
    fun getLocalDatabase(@ApplicationContext context: Context): ArticleDatabase
    {
        return Room.databaseBuilder(context, ArticleDatabase::class.java,"article_database").build()
    }

    @Provides
    @Singleton
    fun getLocalDao(db: ArticleDatabase): ArticleDao? {
        return db.getDao
    }


}