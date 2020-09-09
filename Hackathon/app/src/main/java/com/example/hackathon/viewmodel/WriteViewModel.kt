package com.example.hackathon.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.*
import com.example.hackathon.network.Service
import com.example.hackathon.widget.MyApplication
import com.example.hackathon.widget.SingleLiveEvent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception

class WriteViewModel : BaseViewModel() {

    var checkMax = MutableLiveData<Boolean>()
    var checkFail = MutableLiveData<Boolean>()
    val plusBtn = SingleLiveEvent<Unit>()
    val uploadBtn = SingleLiveEvent<Unit>()
    val arrayList = MutableLiveData<ArrayList<VoteList>>()
    private val voteList = ArrayList<String>()

    val status = MutableLiveData<String>()

    var editText = MutableLiveData<String>()

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit

    var i = 0

    fun plusView(){
        if(voteList.size < 5){
            voteList.add(i, "내용")
            arrayList.value = arrayListOf(VoteList(voteList))
            Log.d("data2", "data: $voteList.size")
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
                    ContentData.arrayList[0],
                    ContentData.arrayList[1],
                    ContentData.arrayList[2],
                    ContentData.arrayList[3],
                    ContentData.arrayList[4]),
                token = "Token ${MyApplication.prefs.getToken("token", "null")}").enqueue(object : Callback<PostData>{
                override fun onResponse(call: Call<PostData>, response: Response<PostData>) {
                    Log.d("LOG", editText.value.toString())
                    Log.d("Log", ContentData.arrayList[0])
                    status.value = response.code().toString()
                    Log.d("LOG", status.value.toString())
                    Log.d("LOG", response.errorBody()?.string().toString())
                }

                override fun onFailure(call: Call<PostData>, t: Throwable) {
                }

            })
        } catch (e: Exception)  {
            ContentData.arrayList.add("null")

        }
    }

    fun plusBtnClick(){
        plusBtn.call()
    }

    fun uploadBtnClick(){
        uploadBtn.call()
    }

}
