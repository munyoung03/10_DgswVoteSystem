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

    var i = 0

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit

    fun getFeed(){
        myAPI = retrofit.create(Service::class.java)
        myAPI.getFeed(token = "Token ${MyApplication.prefs.getToken("token", "fuck")}").enqueue(object : Callback<List<GetSubJect>>{
            override fun onResponse(call: Call<List<GetSubJect>>, response: Response<List<GetSubJect>>) {

                Log.d("LOG", response.code().toString())

                val count = response.body()?.get(0)?.pk

                Log.d("LOG", count.toString())

                MyApplication.prefs.setMaxPk("maxpk", count!!)

                for(i in i..(count-1)!!) {
                    MyApplication.prefs.setSubJect("subJect_${i}", response.body()?.get(i)?.subject.toString())
                    MyApplication.prefs.setPk("Pk_${i}", response.body()?.get(i)?.pk!!)
                }
            }

            override fun onFailure(call: Call<List<GetSubJect>>, t: Throwable) {
                Log.d("LOG", t.message.toString())
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
                    Log.d("LOG", response.body()?.token.toString())
                    Log.d("LOG", status.value.toString())
                }
            })
    }

    fun loginBtnClick(){
        loginBtn.call()
    }
}