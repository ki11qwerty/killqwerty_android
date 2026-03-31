package com.killqwerty.android.domain.repository

import com.killqwerty.android.domain.data.NewsModel

interface NewsRepository {
    suspend fun getTopHeadlines(page: Int, pageSize: Int): List<NewsModel>
    suspend fun getEverything(page: Int, pageSize: Int = 100, language: String? = null, query : String? = null): List<NewsModel>
}