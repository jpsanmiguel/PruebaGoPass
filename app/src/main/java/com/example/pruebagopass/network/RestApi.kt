package com.example.pruebagopass.network

import com.example.pruebagopass.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi {

    @POST("client/registre/")
    fun addUser(@Body userInfo: UserInfo): Call<UserInfo>
}