package com.example.hackathon.view.activity

import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivityLoginBinding
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.viewmodel.LoginViewModel
import com.example.hackathon.widget.extension.startActivity
import com.example.hackathon.widget.extension.toast

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>() {

    override val viewModel: LoginViewModel = LoginViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
    }

    override fun observerViewModel() {
        with(viewModel){
            loginBtn.observe(this@LoginActivity, Observer {
                login()
            })
            status.observe(this@LoginActivity, Observer {
                if(status.value == "200")
                {
                    getFeed()
                }
                else{
                    toast("로그인 실패")
                }
            })

            loginCheck.observe(this@LoginActivity, Observer {
                if(loginCheck.value == true){
                    startActivity(MainActivity::class.java)
                }
                else{
                    toast("로그인 실패")
                }
            })
        }
    }


}