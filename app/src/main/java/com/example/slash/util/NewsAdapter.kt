package com.example.slash.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.slash.database.models.Article
import com.example.slash.databinding.NewsListItemBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    private val articles=ArrayList<Article>()

    class ViewHolder(private val binding: NewsListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.titleTxt.text = article.title
            Glide.with(binding.root.context).asBitmap().load(article.urlToImage)
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=NewsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       
    }

    override fun getItemCount(): Int {
      return articles.size
    }
    fun updateArticleItems(updatedList: List<Article>) {
        val diffCallback = ArticleDiffUtils(this.articles, updatedList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.articles.clear()
        this.articles.addAll(updatedList)
        diffResult.dispatchUpdatesTo(this)
    }

}