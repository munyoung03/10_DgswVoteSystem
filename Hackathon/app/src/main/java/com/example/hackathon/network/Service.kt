package com.example.hackathon.network

import com.example.hackathon.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Service {

    @POST("auth/login")
    fun login(
        @Body loginBody: LoginBody
    ) : Call<LoginData>

    @POST("auth/signUp")
    fun signUp(
        @Body signUpBody: SignUpBody
    ) : Call<SignUpData>

    @GET("vote/feed")
    fun getFeed(
        @Header("token") token: String
    ) : Call<GetSubJect>
}