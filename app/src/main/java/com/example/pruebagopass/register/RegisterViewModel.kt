package com.example.pruebagopass.register

import android.app.AlertDialog
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pruebagopass.models.UserInfo
import com.example.pruebagopass.network.RestApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _user = MutableLiveData<UserInfo>()

    val user: LiveData<UserInfo>
        get() = _user

    private fun addUser(idType: String, id: String, name: String, lastName: String, phone: String, email: String, password: String) {
        coroutineScope.launch {
            val addUserDeferred = RestApi.RestApiService.retrofitService.addUserAsync(idType, Integer.parseInt(id), name, lastName, phone, email, password)
            try {
                val result = addUserDeferred.await()
                _user.value = result.data
                Log.d("AAAAA wttfff",  "$result")
            } catch (e: Exception) {
                Log.d("AAAAA error",  "${e.message}")
            }
        }
    }

    fun saveUser(idType: String, id: String, name: String, lastName: String, phone: String, email: String, password: String) {
        addUser(idType, id, name, lastName, phone, email, password)
    }
}