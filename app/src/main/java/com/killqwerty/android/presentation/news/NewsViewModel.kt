package com.killqwerty.android.presentation.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.killqwerty.android.data.local.db.LocalService
import com.killqwerty.android.data.local.entity.SampleEntity
import com.killqwerty.android.domain.data.NewsModel
import com.killqwerty.android.domain.interactor.NewsInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.collections.plus

data class NewsState(
    val news: List<NewsModel> = listOf(),
    val sampleItems: List<SampleEntity> = emptyList(), //TODO : просто набросок чтобы понимать как работать с флоу в MVI
    val isLoading: Boolean = true,
    val page: Int = 1,
    val error: String? = null,
    val hasMore: Boolean = true
)

sealed interface NewsEvent {
    data object OnStart : NewsEvent
    data object LoadNews : NewsEvent
    data class AddSampleItem(val name: String) : NewsEvent
}

class NewsViewModel(
    private val newsInteractor: NewsInteractor,
    private val localService: LocalService
) : ViewModel() {
    private val _state = MutableStateFlow(NewsState())
    val state: StateFlow<NewsState> = _state.asStateFlow()

    init {
        observeSampleItems()
    }

    fun onEvent(event: NewsEvent) {
        when (event) {
            NewsEvent.OnStart -> {
                loadNewsPage(true)
            }

            NewsEvent.LoadNews -> {

            }

            is NewsEvent.AddSampleItem -> {
                addSampleItem(event.name)
            }
        }
    }

    private fun loadNewsPage(reset: Boolean) {
        viewModelScope.launch {
            val nextPage = if (reset) 1 else _state.value.page
            _state.update { it.copy(isLoading = true, error = null) }

            runCatching { newsInteractor.getEverything(page = nextPage, pageSize = PAGE_SIZE) }
                .onSuccess { pageItems ->
                    _state.update { current ->
                        val merged = if (reset) pageItems else current.news + pageItems
                        current.copy(
                            news = merged,
                            isLoading = false,
                            page = if (pageItems.isEmpty()) current.page else nextPage + 1,
                            hasMore = pageItems.size == PAGE_SIZE,
                            error = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            error = throwable.message ?: "Failed to load news"
                        )
                    }
                }
        }
    }

    private fun observeSampleItems() {
        viewModelScope.launch {
            localService.observeAll().collect { items ->
                _state.update { it.copy(sampleItems = items) }
            }
        }
    }

    private fun addSampleItem(name: String) {
        viewModelScope.launch {
            localService.add(name)
        }
    }

    private companion object {
        const val PAGE_SIZE = 20
    }
}