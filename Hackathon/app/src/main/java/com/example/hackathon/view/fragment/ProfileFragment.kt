package com.example.hackathon.view.fragment

import com.example.hackathon.R
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentProfileBinding
import com.example.hackathon.viewmodel.ProfileViewModel
import com.example.hackathon.viewmodel.SearchViewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding, ProfileViewModel>() {

    override val viewModel: ProfileViewModel = ProfileViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_survey

    override fun init() {
    }

    override fun observerViewModel() {
    }

}