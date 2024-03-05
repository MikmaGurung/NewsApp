package com.example.news.NewsApi

import com.example.news.domain.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
//GET https://newsapi.org/v2/top-headlines?country=us&apiKey=API_KEY
    @GET("top-headlines")
    suspend fun getNews(
    @Query("country") country : String = "us",
    @Query("apiKey") apiKey : String = ApiKey
    ) : NewsResponse
    companion object{
       const val ApiKey = "2b3350c2e130493a94f280d8c05ca388"
        const  val baseUrl = "https://newsapi.org/v2/"
    }
}