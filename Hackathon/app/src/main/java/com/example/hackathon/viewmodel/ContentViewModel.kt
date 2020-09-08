package com.example.hackathon.viewmodel

import com.example.hackathon.base.BaseViewModel
import com.example.hackathon.network.Service
import retrofit2.Retrofit

class ContentViewModel : BaseViewModel() {

    lateinit var myAPI: Service
    lateinit var retrofit: Retrofit

    fun getDetail(){

    }
}