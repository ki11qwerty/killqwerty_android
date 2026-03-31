package com.killqwerty.android.data.dto

data class NewsApiArticleDto(
    val source : SourceDto? = null,
    val author : String? = null,
    val title: String? = null,
    val description: String? = null,
    val url : String? = null,
    val urlToImage : String? = null,
    val publishedAt : String? = null,
    val content: String? = null
)
data class SourceDto(
    val id : String? = null,
    val name : String? = null
)