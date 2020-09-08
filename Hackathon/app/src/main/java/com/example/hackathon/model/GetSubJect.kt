package com.example.hackathon.model

data class GetSubJect (
    val list : ArrayList<List>
){
    data class List(
        val pk: Int,
        val subject : String
    )
}