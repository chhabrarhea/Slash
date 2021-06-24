package com.example.slash.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.slash.database.Repository
import com.example.slash.database.models.Article
import com.example.slash.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: Repository):ViewModel(){

    fun refresh():LiveData<Resource<List<Article>>>{
        return repository.getArticles().asLiveData()
    }
}
