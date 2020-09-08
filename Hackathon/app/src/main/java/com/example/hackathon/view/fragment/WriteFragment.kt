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
import com.example.hackathon.databinding.FragmentWriteBinding
import com.example.hackathon.viewmodel.SearchViewModel
import com.example.hackathon.viewmodel.WriteViewModel

class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>() {

    override val viewModel: WriteViewModel = WriteViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_write

    override fun init() {
    }

    override fun observerViewModel() {
    }

}