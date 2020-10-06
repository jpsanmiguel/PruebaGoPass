package com.example.pruebagopass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebagopass.models.EstablishmentInfo
import com.example.pruebagopass.models.ResponseObject
import com.example.pruebagopass.network.RestApi.RestApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllEstablishmentsData()

    }

//    fun getAllEstablishments() {
//        RestApiService.retrofitService.getAllEstablishment().enqueue( object: Callback<List<EstablishmentInfo>> {
//            override fun onFailure(call: Call<List<EstablishmentInfo>>, t: Throwable) {
//                text.text = "Failure: " + t.message
//            }
//
//            override fun onResponse(call: Call<List<EstablishmentInfo>>, response: Response<List<EstablishmentInfo>>) {
//                text.text = "Success: ${response.body()?.size} establishments retrieved."
//            }
//        })
//    }
//
//    fun getAllEstablishmentsString() {
//        RestApiService.retrofitService.getAllEstablishmentString().enqueue( object: Callback<String> {
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                text.text = "Failure: " + t.message
//            }
//
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                text.text = response.body()
//            }
//        })
//    }

    fun getAllEstablishmentsData() {
        RestApiService.retrofitService.getAllEstablishmentData().enqueue( object: Callback<ResponseObject> {
            override fun onFailure(call: Call<ResponseObject>, t: Throwable) {
                text.text = "Failure: " + t.message
            }

            override fun onResponse(call: Call<ResponseObject>, response: Response<ResponseObject>) {
                text.text = "${response.body()!!.data}"
            }
        })
    }
}