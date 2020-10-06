package com.example.pruebagopass.network

import com.example.pruebagopass.models.EstablishmentInfo
import com.example.pruebagopass.models.ResponseObject
import com.example.pruebagopass.models.UserInfo
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RestApi {

    @POST("client/registre/")
    fun addUser(@Body userInfo: UserInfo): Call<UserInfo>


    @GET("establishment/getAllEstablishment")
    fun getAllEstablishmentString(): Call<String>

    @GET("establishment/getAllEstablishment")
    fun getAllEstablishmentData(): Deferred<ResponseObject>

    @GET("establishment/getAllEstablishment")
    fun getAllEstablishment(): Call<List<EstablishmentInfo>>

    object RestApiService {
        val retrofitService: RestApi by lazy { ServiceBuilder.buildService(RestApi::class.java) }
    }
}