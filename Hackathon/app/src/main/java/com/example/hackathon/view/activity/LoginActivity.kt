package com.example.hackathon.view.activity

import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivityLoginBinding
import com.example.hackathon.viewmodel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel = LoginViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun init() {}

    override fun observerViewModel() {}


}