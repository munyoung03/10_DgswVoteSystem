package com.example.hackathon.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.DetailData
import com.example.hackathon.model.ResultBody
import com.example.hackathon.network.Service
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class ContentViewModel : BaseViewModel() {

    val end = MutableLiveData<Boolean>()

    val subject = MutableLiveData<String>()
    val item1 = MutableLiveData<String>()
    val item2 = MutableLiveData<String>()
    val item3 = MutableLiveData<String>()
    val item4 = MutableLiveData<String>()
    val item5 = MutableLiveData<String>()
    val item1Cnt = MutableLiveData<String>()
    val item2Cnt = MutableLiveData<String>()
    val item3Cnt = MutableLiveData<String>()
    val item4Cnt = MutableLiveData<String>()
    val item5Cnt = MutableLiveData<String>()

    val btn = SingleLiveEvent<Unit>()

    val status = MutableLiveData<String>()
    val resultStatus = MutableLiveData<String>()
    var viewModelPk = 0

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit

    fun getDetail(pk : Int){
        myAPI = retrofit.create(Service::class.java)
        myAPI.getDetail(token = "Token ${MyApplication.prefs.getToken("token", "fuck")}",pk = pk).enqueue(object : Callback<DetailData>{
            override fun onResponse(call: Call<DetailData>, response: Response<DetailData>) {
                viewModelPk = pk
                Log.d("Log", pk.toString())
                Log.d("LOg", response.code().toString())
                subject.value = response.body()?.subject
                item1.value = response.body()?.item1
                item2.value = response.body()?.item2
                item3.value = response.body()?.item3
                item4.value = response.body()?.item4
                item5.value = response.body()?.item5
                item1Cnt.value = response.body()?.item1Cnt.toString()
                item2Cnt.value = response.body()?.item2Cnt.toString()
                item3Cnt.value = response.body()?.item3Cnt.toString()
                item4Cnt.value = response.body()?.item4Cnt.toString()
                item5Cnt.value = response.body()?.item5Cnt.toString()

                status.value = response.code().toString()

                Log.d("Log", item1.value.toString())

                end.value = true
            }

            override fun onFailure(call: Call<DetailData>, t: Throwable) {
            }
        })
    }


    fun sendResult(){
        myAPI = retrofit.create(Service::class.java)
        myAPI.sendResult(resultBody = ResultBody(item1Cnt = item1Cnt.value?.toInt()!!,
            item2Cnt = item2Cnt.value?.toInt()!!,
            item3Cnt = item3Cnt.value?.toInt()!!,
            item4Cnt = item4Cnt.value?.toInt()!!,
            item5Cnt = item5Cnt.value?.toInt()!!),
            token = "Token ${MyApplication.prefs.getToken("token", "fuck")}",
            pk = viewModelPk).enqueue(object : Callback<DetailData>{
            override fun onResponse(call: Call<DetailData>, response: Response<DetailData>) {
                Log.d("Log", viewModelPk.toString())
                Log.d("LOg", response.code().toString())
                resultStatus.value = response.code().toString()
                Log.d("Log", item1.value.toString())
                end.value = true
            }

            override fun onFailure(call: Call<DetailData>, t: Throwable) {
            }
        })
    }

    fun btnClick()
    {
        btn.call()
    }
}