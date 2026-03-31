package com.killqwerty.android.data.repository

import com.killqwerty.android.data.mapper.toDomain
import com.killqwerty.android.data.remote.news.NewsApiService
import com.killqwerty.android.domain.data.NewsModel
import com.killqwerty.android.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class NewsRepositoryImpl(
    private val api: NewsApiService,
    private val apiKey: String
) : NewsRepository {
    override suspend fun getTopHeadlines(page: Int, pageSize: Int): List<NewsModel> {
        return api.getTopHeadlines(page = page, pageSize = pageSize, apiKey = apiKey).articles.map { dto ->
            dto.toDomain()
        }
    }

    override suspend fun getEverything(
        page: Int,
        pageSize: Int,
        language: String?,
        query: String?
    ): List<NewsModel> {
        return api.getEverything(page = page, pageSize = pageSize, apiKey = apiKey).articles.map { dto ->
            dto.toDomain()
        }
    }
}

//class SettingsRepositoryImpl : SettingsRepository {
//    private val counter = MutableStateFlow(0)
//
//    override fun observeCounter(): Flow<Int> = counter.asStateFlow()
//
//    override suspend fun incrementCounter() {
//        counter.update { it + 1 }
//    }
//}
//
//class TrainingRepositoryImpl : TrainingRepository {
//    private val counter = MutableStateFlow(0)
//
//    override fun observeCounter(): Flow<Int> = counter.asStateFlow()
//
//    override suspend fun incrementCounter() {
//        counter.update { it + 1 }
//    }
//}