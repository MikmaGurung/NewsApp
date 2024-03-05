package com.example.news.NewsScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.Article
import com.example.news.domain.Repository.NewsRepository
import com.example.news.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsScreenViewmodel @Inject constructor (
    private val newsRepository: NewsRepository
)
    : ViewModel ()
{
    var articles by mutableStateOf<List<Article>>(emptyList())

    init {
        getNewsArticles()
    }
    private fun getNewsArticles(){
        viewModelScope.launch {
            val result =  newsRepository.getTopHeadlines()
            when (result){
                is Resource.Success -> {
                    articles = result.data ?: emptyList()
                }
                is Resource.Error -> {

                }
            }
        }
    }


}