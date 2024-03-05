package com.example.news.domain.Repository

import android.annotation.SuppressLint
import com.example.news.NewsApi.NewsApi
import com.example.news.domain.Article
import com.example.news.util.Resource
import okio.IOException

import retrofit2.Response

class NewsRepositoryImplementation (
    private val newsApi: NewsApi
): NewsRepository{
    override suspend fun getTopHeadlines(): Resource<List<Article>> {
        return try {
          val response = newsApi.getNews()
            Resource.Success(response.articles)
        }catch (e : Error ){
               Resource.Error(message = "failed to fetch news ${e.message}")
        }
    }
}