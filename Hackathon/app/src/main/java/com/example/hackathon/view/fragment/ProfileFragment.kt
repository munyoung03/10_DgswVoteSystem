package com.example.hackathon.view.fragment

import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.adapter.MainAdapter
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentProfileBinding
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.viewmodel.ProfileViewModel
import com.example.hackathon.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.fragment_survey.*

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override val viewModel: ProfileViewModel = ProfileViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_profile

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
        viewModel.getFeed()
    }

    override fun observerViewModel() {
        with(viewModel){
            finish.observe(this@ProfileFragment, Observer {
                val mAdapter = MainAdapter(subjectList)
                mRecyclerView.adapter = mAdapter
            })
        }
    }

}