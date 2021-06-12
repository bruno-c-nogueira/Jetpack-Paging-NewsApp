package com.brunets.newsapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.brunets.newsapp.data.NewsClient
import com.brunets.newsapp.data.model.Article
import com.brunets.newsapp.data.model.ArticlePageSource
import kotlinx.coroutines.flow.Flow

class NewsViewModel : ViewModel() {

    val articles = MutableLiveData<ArrayList<Article>>()

    val articlesFlow: Flow<PagingData<Article>> = Pager(PagingConfig(pageSize = 10)) {
        ArticlePageSource(NewsClient.service)
    }.flow
        .cachedIn(viewModelScope)
}