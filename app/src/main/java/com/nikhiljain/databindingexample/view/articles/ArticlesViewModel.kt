package com.nikhiljain.databindingexample.view.articles

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikhiljain.databindingexample.data.ArticlesUtil
import com.nikhiljain.databindingexample.models.Article

class ArticlesViewModel : ViewModel() {

    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        loadArticles()
    }

    private fun loadArticles() {
        _articles.value = ArticlesUtil.articles
    }
}
