package com.example.news.domain.Repository

import com.example.news.domain.Article
import com.example.news.util.Resource

interface NewsRepository {
    suspend fun getTopHeadlines(
    ) :Resource<List<Article>>
}