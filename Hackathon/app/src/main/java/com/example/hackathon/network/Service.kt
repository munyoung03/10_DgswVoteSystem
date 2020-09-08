package com.example.hackathon.network

import com.example.hackathon.model.LoginBody
import com.example.hackathon.model.LoginData
import com.example.hackathon.model.SignUpBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Service {

    @POST("auth/login")
    fun login(
        @Body loginBody: LoginBody
    ) : Call<LoginData>

    @POST("auth/register")
    fun signUp(
        @Body signUpBody: SignUpBody
    ) : Call<SignUpBody>
}