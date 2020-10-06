package com.example.pruebagopass.establishments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebagopass.models.EstablishmentInfo
import com.example.pruebagopass.models.ResponseObject
import com.example.pruebagopass.network.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class EstablishmentViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _establishments = MutableLiveData<List<EstablishmentInfo>>()

    val establishments: LiveData<List<EstablishmentInfo>>
        get() = _establishments

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

    private fun getAllEstablishmentsData() {
        coroutineScope.launch {
            val getEstablishmentsDeferred = RestApi.RestApiService.retrofitService.getAllEstablishmentData()
            try {
                val listResult = getEstablishmentsDeferred.await()
                _status.value = "Success: ${listResult.data.size}"
                _establishments.value = listResult.data
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}