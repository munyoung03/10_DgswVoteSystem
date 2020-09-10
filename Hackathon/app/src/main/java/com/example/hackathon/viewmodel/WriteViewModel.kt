package com.example.hackathon.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackathon.adapter.VoteAddAdapter
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.*
import com.example.hackathon.network.Service
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.SingleLiveEvent
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception

class WriteViewModel : BaseViewModel() {

    var checkMax = MutableLiveData<Boolean>()
    val plusBtn = SingleLiveEvent<Unit>()
    val uploadBtn = SingleLiveEvent<Unit>()
    val voteList = MutableLiveData<ArrayList<VoteList>>()

    val status = MutableLiveData<String>()

    var editText = MutableLiveData<String>()

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit

    var i = 0

    fun plusView(){
        if(voteList.value == null) {
            voteList.value = arrayListOf(VoteList("null"),VoteList("null"),VoteList("null"),VoteList("null"),VoteList("null"))
        }
        if(i < 5){
            voteList.value?.set(i, VoteList(""),)
            Log.d("data2", "data: $i,  Add Data")
            i += 1
        }else{
            checkMax.value = false
        }
    }

    fun upload(){
        try {
            myAPI = retrofit.create(Service::class.java)
            myAPI.postVote(
                postBody = PostBody(editText.value.toString(),
                    voteList.value!![0].voteList,
                    voteList.value!![1].voteList,
                    voteList.value!![2].voteList,
                    voteList.value!![3].voteList,
                    voteList.value!![4].voteList),
                token = "Token ${MyApplication.prefs.getToken("token", "null")}").enqueue(object : Callback<PostData>{
                override fun onResponse(call: Call<PostData>, response: Response<PostData>) {

                    val gson = Gson()
                    Log.d("LOG", gson.toJson(call.request().body()))
                    Log.d("LOG", editText.value.toString())
                    status.value = response.code().toString()
                    Log.d("LOG", status.value.toString())
                    Log.d("LOG", response.errorBody()?.string().toString())
                }

                override fun onFailure(call: Call<PostData>, t: Throwable) {
                }

            })
        } catch (e: Exception)  {
            e.printStackTrace()
        }
    }

    fun plusBtnClick(){
        plusBtn.call()
    }

    fun uploadBtnClick(){
        uploadBtn.call()
    }

}
