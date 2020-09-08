package com.example.hackathon.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackathon.adapter.MainAdapter
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.*
import com.example.hackathon.network.Service
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class LoginViewModel : BaseViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    var status = MutableLiveData<String>()
    val loginBtn = SingleLiveEvent<Unit>()
    val subJectList = ArrayList<String>()
    val pkList = ArrayList<Int>()
    var i = 0

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit

    fun getFeed(){
        myAPI = retrofit.create(Service::class.java)
        myAPI.getFeed().enqueue(object : Callback<GetSubJect>{
            override fun onResponse(call: Call<GetSubJect>, response: Response<GetSubJect>) {
                val count = response.body()?.list?.get(0)?.pk

                for(i in i..count!!) {
                    subJectList.add(response.body()?.list?.get(i)?.subject.toString())
                    pkList.add(response.body()?.list?.get(i)?.pk!!)
                }


            }

            override fun onFailure(call: Call<GetSubJect>, t: Throwable) {
            }

        })
    }

    fun login(){
        myAPI = retrofit.create(Service::class.java)
        myAPI.login(
            LoginBody(
            email = email.value.toString(),
            password = password.value.toString()))
            .enqueue(object : Callback<LoginData> {
                override fun onFailure(call: Call<LoginData>, t: Throwable) {
                    Log.d("LOG", "t : ${t.message}")
                }

                override fun onResponse(call: Call<LoginData>, response: Response<LoginData>) {
                    status.value = response.code().toString()
                    MyApplication.prefs.setToken("token", response.body()?.token.toString())
                    Log.d("LOG", status.value.toString())
                    Log.d("LOG", response.errorBody()?.string().toString())
                }
            })
    }

    fun loginBtnClick(){
        loginBtn.call()
    }
}