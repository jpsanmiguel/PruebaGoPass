package com.example.pruebagopass.network

import com.example.pruebagopass.models.EstablishmentInfo
import com.example.pruebagopass.models.ResponseObject
import com.example.pruebagopass.models.UserAddResponse
import com.example.pruebagopass.models.UserInfo
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.*

interface RestApi {

    @POST("client/registre/")
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    fun addUserAsync(
        @Field("tipoDocumento") tipoDocumento: String,
        @Field("numeroIdentificacion") numeroIdentificacion: Int,
        @Field("nombres") nombres: String,
        @Field("apellidos") apellidos: String,
        @Field("telefonoMovil") telefonoMovil: String,
        @Field("correo") correo: String,
        @Field("password") password: String
    ): Deferred<UserAddResponse>

    @GET("establishment/getAllEstablishment")
    fun getAllEstablishmentAsync(): Deferred<ResponseObject>

    object RestApiService {
        val retrofitService: RestApi by lazy { ServiceBuilder.buildService(RestApi::class.java) }
    }
}