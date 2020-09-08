package com.example.hackathon.viewmodel

import android.R
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

    fun plusView(){
        var i = 0
        if(VoteList().voteList.size <= 5){
            VoteList().voteList[i]
            i += 1
        }else{
            checkMax.value = false
        }
    }

    fun plusBtnClick(){
        plusBtn.call()
    }

}