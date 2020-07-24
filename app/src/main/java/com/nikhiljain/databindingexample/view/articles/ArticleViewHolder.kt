package com.nikhiljain.databindingexample.view.articles

import androidx.recyclerview.widget.RecyclerView
import com.nikhiljain.databindingexample.databinding.ListItemArticleBinding
import com.nikhiljain.databindingexample.models.Article

class ArticleViewHolder(
    private val binding: ListItemArticleBinding,
    itemClickListener: ArticleViewClickListener
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.itemClickListener = itemClickListener
    }

    fun bind(article: Article) {
        binding.article = article
    }
}
