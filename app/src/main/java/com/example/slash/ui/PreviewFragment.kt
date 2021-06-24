package com.example.slash.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.slash.databinding.FragmentPreviewBinding
import com.example.slash.util.ArticlesAdapter
import com.example.slash.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PreviewFragment : Fragment() {
    private val viewModel:ArticleViewModel by viewModels()
    private lateinit var binding:FragmentPreviewBinding
    private lateinit var mAdapter:ArticlesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding= FragmentPreviewBinding.inflate(layoutInflater,null,false)
        mAdapter= ArticlesAdapter()
        loadContent()
        binding.apply {
        refreshLayout.setOnRefreshListener { loadContent() }
        newsListRv.apply {
            layoutManager=LinearLayoutManager(requireContext())
            this.adapter=mAdapter
        }}

        return binding.root
    }
    private fun loadContent(){
        viewModel.refresh().observe(viewLifecycleOwner,{
            it.data?.let {
                    it1 -> mAdapter.updateArticleItems(it1) }
            binding.apply {
                refreshLayout.isRefreshing= it is Resource.Loading && it.data.isNullOrEmpty()
                errorMessage.isVisible = it is Resource.Error && it.data.isNullOrEmpty()
            }

        })
    }
}