package com.example.hackathon.view.activity

import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivitySignupBinding
import com.example.hackathon.viewmodel.SignUpViewModel
import com.example.hackathon.widget.extension.noFinishStartActivity
import com.example.hackathon.widget.extension.toast

class SignUpActivity : BaseActivity<ActivitySignupBinding, SignUpViewModel>(){

    override val viewModel: SignUpViewModel = SignUpViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_signup

    override fun init() {}

    override fun observerViewModel() {
        with(viewModel) {
            nextBtn.observe(this@SignUpActivity, Observer {
                checkNull()
            })

            checkNull.observe(this@SignUpActivity, Observer {
                if (checkNull.value == true) {
                    setData()
                    noFinishStartActivity(SelectRoleActivity::class.java)
                } else {
                    toast("빈칸을 모두 채워주세요")
                }
            })
        }
    }

}