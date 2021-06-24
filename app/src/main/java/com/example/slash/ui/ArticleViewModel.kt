package com.example.slash.ui

import androidx.lifecycle.*
import com.example.slash.database.models.Response
import com.example.slash.database.remote.Service
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val apiService: Service):ViewModel(){
    lateinit var response:LiveData<Response>
    fun getUsers(){
        response=liveData(Dispatchers.IO){
        emit(apiService.getArticles())
    }

    }
}