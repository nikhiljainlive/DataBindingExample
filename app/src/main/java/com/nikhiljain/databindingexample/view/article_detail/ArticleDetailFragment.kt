package com.nikhiljain.databindingexample.view.article_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nikhiljain.databindingexample.R
import com.nikhiljain.databindingexample.databinding.FragmentArticleDetailBinding
import com.nikhiljain.databindingexample.models.Article

class ArticleDetailFragment : Fragment() {
    private lateinit var binding: FragmentArticleDetailBinding
    private lateinit var viewModelFactory : ArticleDetailViewModelFactory
    private lateinit var detailViewModel: ArticleDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_article_detail,
            container,
            false
        )
        viewModelFactory =
            ArticleDetailViewModelFactory(arguments?.getParcelable(KEY_ARTICLE))
        detailViewModel = ViewModelProvider(this, viewModelFactory)
            .get(ArticleDetailViewModel::class.java)
        binding.detailViewModel = detailViewModel
        return binding.root
    }

    companion object {
        private const val KEY_ARTICLE = "article"
        fun newInstance(article: Article): ArticleDetailFragment {
            val instance = ArticleDetailFragment()
            instance.arguments = Bundle().apply {
                putParcelable(KEY_ARTICLE, article)
            }
            return instance
        }
    }
}
