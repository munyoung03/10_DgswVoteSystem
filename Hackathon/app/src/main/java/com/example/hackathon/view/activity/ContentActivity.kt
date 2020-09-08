package com.example.hackathon.view.activity

import androidx.annotation.ContentView
import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivityContentBinding
import com.example.hackathon.viewmodel.ContentViewModel
import com.example.hackathon.viewmodel.SurveyViewModel

class ContentActivity : BaseActivity<ActivityContentBinding, ContentViewModel>() {

    override val viewModel: ContentViewModel = ContentViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_content

    override fun init() {
        val pk = intent.getIntExtra("pk", 0)
    }

    override fun observerViewModel() {
    }

}