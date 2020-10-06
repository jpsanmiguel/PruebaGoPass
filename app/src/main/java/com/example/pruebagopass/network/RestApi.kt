package com.example.pruebagopass.network

import com.example.pruebagopass.UserInfo
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestApi {

    @POST("client/registre/")
    fun addUser(@Body userInfo: UserInfo): Call<UserInfo>

    @GET("establishment/getAllEstablishment")
    fun getAllEstablishment(): Call<String>

    object RestApiService {
        val retrofitService: RestApi by lazy { ServiceBuilder.buildService(RestApi::class.java) }
    }
}