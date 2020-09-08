package com.example.hackathon.view.fragment

import com.example.hackathon.R
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentNotificationBinding
import com.example.hackathon.viewmodel.NotificationViewModel
import com.example.hackathon.viewmodel.SearchViewModel

class NotificationFragment : BaseFragment<FragmentNotificationBinding, NotificationViewModel>(){

    override val viewModel: NotificationViewModel = NotificationViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_notification

    override fun init() {
    }

    override fun observerViewModel() {
    }

}