package com.example.hackathon.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hackathon.R
import com.example.hackathon.adapter.MainAdapter
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentSearchBinding
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.viewmodel.SearchViewModel
import com.example.hackathon.viewmodel.SurveyViewModel
import kotlinx.android.synthetic.main.fragment_survey.*

class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val viewModel: SearchViewModel = SearchViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_search

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
        viewModel.getFeed()
    }

    override fun observerViewModel() {
        with(viewModel){
            finish.observe(this@SearchFragment, Observer {
                val mAdapter = MainAdapter(subjectList)
                mRecyclerView.adapter = mAdapter
            })
        }
    }

}