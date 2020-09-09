package com.example.hackathon.viewmodel

import android.R
import android.util.Log
import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.model.VoteList
import com.example.hackathon.widget.SingleLiveEvent

class WriteViewModel : BaseViewModel() {

    var checkMax = MutableLiveData<Boolean>()
    val plusBtn = SingleLiveEvent<Unit>()
    val arrayList = MutableLiveData<ArrayList<VoteList>>()
    private val voteList = ArrayList<String>()

    var i = 0

    fun plusView(){
        if(voteList.size < 5){
            voteList.add(i, "내용")
            arrayList.value = arrayListOf(VoteList(voteList))
            i += 1
        }else{
            checkMax.value = false
        }
    }

    fun plusBtnClick(){
        plusBtn.call()
    }

}