package com.killqwerty.android.domain.data.Mock

import com.killqwerty.android.domain.data.NewsModel
import com.killqwerty.android.domain.data.Source

class Mock{}


fun Mock.toModel(): NewsModel {
    return NewsModel(
        source = Source("id", "name"),
        author = "author",
        title = "title",
        description = "description",
        url = "url",
        urlToImage = "urlToImage",
        publishedAt = "publishedAt",
        content = "content"
    )
}