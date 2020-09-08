package com.example.hackathon.viewmodel

import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.widget.SingleLiveEvent

class IntroViewModel : BaseViewModel(){

    val loginBtn = SingleLiveEvent<Unit>()
    val signUpBtn = SingleLiveEvent<Unit>()

    fun loginBtnClick() {
        loginBtn.call()
    }

    fun signUpClick(){
        signUpBtn.call()
    }
}