package com.killqwerty.android.data.mapper

import com.killqwerty.android.data.dto.NewsApiArticleDto
import com.killqwerty.android.data.dto.SourceDto
import com.killqwerty.android.domain.data.NewsModel
import com.killqwerty.android.domain.data.Source

fun NewsApiArticleDto.toDomain() : NewsModel {
    return NewsModel(
        source?.toDomain(),
        author ?: "",
        title ?: "empty",
        description ?: "empty desc",
        url,
        urlToImage,
        publishedAt ?: "",
        content ?: "empty"
    )
}

fun SourceDto.toDomain() : Source {
    return Source(
        id ,
        name
    )
}