package com.example.hackathon.view.activity

import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivityIntroBinding
import com.example.hackathon.viewmodel.IntroViewModel
import com.example.hackathon.widget.extension.startActivity

class IntroActivity : BaseActivity<ActivityIntroBinding, IntroViewModel>(){

    override val viewModel: IntroViewModel = IntroViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_intro

    override fun init() {

    }

    override fun observerViewModel() {
        with(viewModel){
            loginBtn.observe(this@IntroActivity, Observer {
                startActivity(LoginActivity::class.java)
            })

            signUpBtn.observe(this@IntroActivity, Observer {
                startActivity(SignUpActivity::class.java)
            })
        }
    }
}