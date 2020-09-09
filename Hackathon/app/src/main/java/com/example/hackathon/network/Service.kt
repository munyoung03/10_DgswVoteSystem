package com.example.hackathon.network

import com.example.hackathon.model.*
import retrofit2.Call
import retrofit2.http.*

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
        @Header("Authorization") token: String
    ) : Call<List<GetSubJect>>

    @GET("vote/detail/{pk}")
    fun getDetail(
        @Header("Authorization") token: String,
        @Path("pk") pk : Int
    ) : Call<DetailData>

    @PATCH("vote/detail/{pk}")
    fun sendResult(
        @Body resultBody: ResultBody,
        @Header("Authorization") token: String,
        @Path("pk") pk : Int
    ) : Call<DetailData>
}