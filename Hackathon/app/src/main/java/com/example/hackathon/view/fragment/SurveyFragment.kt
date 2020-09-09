package com.example.hackathon.view.fragment

import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.adapter.MainAdapter
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentSurveyBinding
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.viewmodel.SurveyViewModel
import kotlinx.android.synthetic.main.fragment_survey.*


class SurveyFragment : BaseFragment<FragmentSurveyBinding, SurveyViewModel>() {

    override val viewModel: SurveyViewModel = SurveyViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_survey

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
        viewModel.getFeed()


    }

    override fun observerViewModel() {
        with(viewModel){
            finish.observe(this@SurveyFragment, Observer {
                val mAdapter = MainAdapter(subjectList)
                mRecyclerView.adapter = mAdapter
            })
        }
    }

}