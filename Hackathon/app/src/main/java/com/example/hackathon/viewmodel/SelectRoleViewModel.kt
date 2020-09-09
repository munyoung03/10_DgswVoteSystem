package com.example.hackathon.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.SignUpBody
import com.example.hackathon.model.SignUpData
import com.example.hackathon.network.Service
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class SelectRoleViewModel : BaseViewModel(){

    val studentBtn = SingleLiveEvent<Unit>()
    val teacherBtn = SingleLiveEvent<Unit>()
    var identity = MutableLiveData<String>()
    var status = MutableLiveData<String>()

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit


    fun signUp(){
        myAPI = retrofit.create(Service::class.java)
        myAPI.signUp(SignUpBody(
            username = MyApplication.prefs.getUsername("signUpName", "없음"),
            email = MyApplication.prefs.getEmail("signUpEmail", "없음"),
            password = MyApplication.prefs.getPassword("signUpPassword", "없음"),
            identity = identity.value.toString()))
            .enqueue(object : Callback<SignUpData> {
            override fun onFailure(call: Call<SignUpData>, t: Throwable) {
                Log.d("LOG", "t : ${t.message.toString()}")
            }

            override fun onResponse(call: Call<SignUpData>, response: Response<SignUpData>) {
                status.value = response.code().toString()

                Log.d("LOG", response.errorBody()?.string().toString())
                Log.d("LOG", response.message())
                Log.d("LOG", status.value.toString())
            }
        })
    }

    fun studentBtnClick() {
        studentBtn.call()
    }

    fun teacherBtnClick() {
        teacherBtn.call()
    }
}