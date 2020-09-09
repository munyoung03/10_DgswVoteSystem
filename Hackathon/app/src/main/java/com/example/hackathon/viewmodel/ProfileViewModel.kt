package com.example.hackathon.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.GetSubJect
import com.example.hackathon.network.Service
import com.example.hackathon.widget.MyApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ProfileViewModel : BaseViewModel() {

    var  finish = MutableLiveData<Boolean>()
    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit
    lateinit var subjectList : ArrayList<GetSubJect>


    fun getFeed(){
        myAPI = retrofit.create(Service::class.java)
        myAPI.getFeed(token = "Token ${MyApplication.prefs.getToken("token", "null")}").enqueue(object :
            Callback<List<GetSubJect>> {
            override fun onResponse(call: Call<List<GetSubJect>>, response: Response<List<GetSubJect>>) {
                Log.d("LOG", response.code().toString())

                subjectList = response.body() as ArrayList<GetSubJect>
                finish.value = true

            }

            override fun onFailure(call: Call<List<GetSubJect>>, t: Throwable) {
                Log.d("LOG", t.message.toString())
            }

        })
    }

}