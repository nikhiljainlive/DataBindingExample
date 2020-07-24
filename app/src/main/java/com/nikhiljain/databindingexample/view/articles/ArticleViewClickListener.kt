package com.nikhiljain.databindingexample.view.articles

import com.nikhiljain.databindingexample.models.Article

interface ArticleViewClickListener {
    fun onArticleClick(article : Article)
}