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
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentSurveyBinding
import com.example.hackathon.viewmodel.SurveyViewModel

class SurveyFragment : BaseFragment<FragmentSurveyBinding, SurveyViewModel>() {

    override val viewModel: SurveyViewModel = SurveyViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_survey

    override fun init() {
    }

    override fun observerViewModel() {
    }

}