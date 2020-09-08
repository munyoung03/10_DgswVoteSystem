package com.example.hackathon.view.activity

import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivitySelectRoleBinding
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.viewmodel.SelectRoleViewModel
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.extension.startActivity
import com.example.hackathon.widget.extension.toast

class SelectRoleActivity : BaseActivity<ActivitySelectRoleBinding, SelectRoleViewModel>(){

    override val viewModel: SelectRoleViewModel = SelectRoleViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_select_role

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
    }

    override fun observerViewModel() {
        with(viewModel){
            studentBtn.observe(this@SelectRoleActivity, Observer {
                toast("잠시만 기다려주세요")
                identity.value = "student"
                signUp()
            })

            teacherBtn.observe(this@SelectRoleActivity, Observer {
                toast("잠시만 기다려주세요")
                identity.value = "teacher"
                signUp()
            })

            status.observe(this@SelectRoleActivity, Observer {
                if(status.value == "200")
                {
                    MyApplication.prefs.setIdentity("identity", identity.value)
                    toast("회원가입 성공")
                    startActivity(MainActivity::class.java)

                }
                else{
                    toast("로그인 실패")
                    startActivity(MainActivity::class.java)
                }
            })
        }
    }


}