package com.example.hackathon.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.SingleLiveEvent

class SignUpViewModel : BaseViewModel(){

    val nextBtn = SingleLiveEvent<Unit>()
    val name = MutableLiveData<String>()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    var checkNull = MutableLiveData<Boolean>()

    fun checkNull() {
        checkNull.value = name.value != null && email.value != null && password.value != null
    }

    fun setData() {

        MyApplication.prefs.setEmail("signUpEmail", email.value)
        MyApplication.prefs.setUsername("signUpName", name.value)
        MyApplication.prefs.setPassword("signUpPassword", password.value)
    }

    fun nextBtnClick() {
        nextBtn.call()
    }
}