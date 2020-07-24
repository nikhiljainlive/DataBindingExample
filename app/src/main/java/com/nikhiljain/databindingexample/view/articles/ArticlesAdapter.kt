package com.nikhiljain.databindingexample.view.articles

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhiljain.databindingexample.R
import com.nikhiljain.databindingexample.databinding.ListItemArticleBinding
import com.nikhiljain.databindingexample.models.Article

class ArticlesAdapter(
    private var articles: List<Article>,
    private val itemClickListener: ArticleViewClickListener
) : RecyclerView.Adapter<ArticleViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ArticleViewHolder {
        val itemBinding =
            DataBindingUtil.inflate<ListItemArticleBinding>(
                LayoutInflater.from(parent.context),
                R.layout.list_item_article,
                parent, false
            )
        return ArticleViewHolder(
            itemBinding,
            itemClickListener
        )
    }

    override fun getItemCount(): Int = articles.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) =
        holder.bind(articles[position])

    fun updateArticles(articles: List<Article>) {
        this.articles = articles
    }
}
