package com.killqwerty.android.data.remote.news

import com.killqwerty.android.data.dto.NewsApiArticleDto


data class NewsApiResponseDto(
    val status: String,
    val totalResults: Int = 0,
    val articles: List<NewsApiArticleDto> = emptyList()
)