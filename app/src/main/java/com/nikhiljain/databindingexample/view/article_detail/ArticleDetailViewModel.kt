package com.nikhiljain.databindingexample.view.article_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikhiljain.databindingexample.models.Article

class ArticleDetailViewModel : ViewModel() {
    private val _article = MutableLiveData<Article>()
    val article = _article as LiveData<Article>

    fun setArticle(article: Article) {
        _article.value = article
    }
}
