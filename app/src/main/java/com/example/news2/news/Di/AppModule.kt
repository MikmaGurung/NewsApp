package com.example.news.Di

import com.example.news.NewsApi.NewsApi
import com.example.news.NewsApi.NewsApi.Companion.baseUrl
import com.example.news.domain.Repository.NewsRepository
import com.example.news.domain.Repository.NewsRepositoryImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent :: class)
object AppModule {
    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi{
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NewsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi) :NewsRepository{
        return NewsRepositoryImplementation(newsApi = newsApi)
    }
}