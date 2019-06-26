package com.example.loadingimagefromapi

import retrofit2.Call
import retrofit2.http.GET


interface APIService {
    @GET("/json/glide.json")
    fun getInfo(): Call<List<model>>

}