package com.example.pruebagopass.establishments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebagopass.models.ResponseObject
import com.example.pruebagopass.network.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EstablishmentViewModel: ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
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
        RestApi.RestApiService.retrofitService.getAllEstablishmentData().enqueue( object:
            Callback<ResponseObject> {
            override fun onFailure(call: Call<ResponseObject>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<ResponseObject>, response: Response<ResponseObject>) {
                _response.value = "${response.body()!!.data}"
            }
        })
    }
}