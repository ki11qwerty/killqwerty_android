package com.killqwerty.android.domain.interactor

import com.killqwerty.android.domain.data.NewsModel
import com.killqwerty.android.domain.repository.NewsRepository

class NewsInteractor(
    private val newsRepository: NewsRepository
) {

    suspend fun getTopHeadlines(page: Int, pageSize: Int): List<NewsModel> {
        return newsRepository.getTopHeadlines(page = page, pageSize = pageSize)
    }

    suspend fun getEverything(
        page: Int,
        pageSize: Int,
        language: String? = null,
        query: String? = null
    ): List<NewsModel> {
        return newsRepository.getEverything(
            page = page,
            pageSize = pageSize,
            language = language,
            query = query
        )
    }
}