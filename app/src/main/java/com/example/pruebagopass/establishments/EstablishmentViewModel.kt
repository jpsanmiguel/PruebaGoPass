package com.example.pruebagopass.establishments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebagopass.models.EstablishmentInfo
import com.example.pruebagopass.network.RestApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
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
        addUser()
    }

    private fun addUser() {
        coroutineScope.launch {
            val addUserDeferred = RestApi.RestApiService.retrofitService.addUserAsync("1", 48762, "asd", "qwe", "123", "asdasfd132sada", "adasdas")
            try {
                val result = addUserDeferred.await()
                Log.d("AAAAA",  "$result")
            } catch (e: Exception) {
                Log.d("BBBBB",  "${e.message}")
            }
        }
    }

    private fun getAllEstablishmentsData() {
        coroutineScope.launch {
            val getEstablishmentsDeferred = RestApi.RestApiService.retrofitService.getAllEstablishmentAsync()
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