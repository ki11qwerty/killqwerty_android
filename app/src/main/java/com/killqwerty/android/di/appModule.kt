package com.killqwerty.android.di

import androidx.room.Room
import com.killqwerty.android.BuildConfig
import com.killqwerty.android.data.local.db.KQDatabase
import com.killqwerty.android.data.local.db.LocalService
import com.killqwerty.android.data.remote.news.NewsApiService
import com.killqwerty.android.data.repository.NewsRepositoryImpl
import com.killqwerty.android.domain.interactor.NewsInteractor
import com.killqwerty.android.domain.repository.NewsRepository
import com.killqwerty.android.presentation.news.NewsViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single {
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    single {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<NewsApiService> {
        get<Retrofit>().create(NewsApiService::class.java)
    }

    single<NewsRepository> {
        NewsRepositoryImpl(
            api = get(),
            apiKey = BuildConfig.NEWS_API_KEY
        )
    }

    single {
        Room.databaseBuilder(get(), KQDatabase::class.java, "app_db")
            .fallbackToDestructiveMigration(false)
            .build()
    }

    single { get<KQDatabase>().sampleDao() }

    single { LocalService(get()) }

    single { NewsInteractor(get()) }

    viewModel { NewsViewModel(get(), get()) }
}