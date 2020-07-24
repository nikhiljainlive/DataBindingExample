package com.nikhiljain.databindingexample.view.articles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.nikhiljain.databindingexample.R
import com.nikhiljain.databindingexample.databinding.FragmentArticlesBinding
import com.nikhiljain.databindingexample.models.Article
import com.nikhiljain.databindingexample.view.article_detail.ArticleDetailFragment

class ArticlesFragment : Fragment() {
    private lateinit var binding: FragmentArticlesBinding
    private lateinit var articlesViewModel: ArticlesViewModel
    private val articlesAdapter = ArticlesAdapter(
        emptyList(),
        getItemClickListener()
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_articles,
            container, false
        )
        return binding.root
    }

    private fun getItemClickListener() = object : ArticleViewClickListener {
        override fun onArticleClick(article: Article) {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.fragment_container_view,
                    ArticleDetailFragment.newInstance(article)
                )
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        articlesViewModel = ViewModelProvider(this)
            .get(ArticlesViewModel::class.java)
        binding.recyclerViewArticles.adapter =
            articlesAdapter
        articlesViewModel.articles.observe(viewLifecycleOwner, Observer {
            it?.let { articlesAdapter.updateArticles(it) }
        })
    }
}