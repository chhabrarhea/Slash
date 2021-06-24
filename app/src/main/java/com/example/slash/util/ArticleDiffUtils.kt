package com.example.slash.util

import androidx.recyclerview.widget.DiffUtil
import com.example.slash.database.models.Article

class ArticleDiffUtils(private val oldList: List<Article>, private val newList: List<Article>): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return oldList[oldItemPosition].id==newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].url==newList[newItemPosition].url
    }
}