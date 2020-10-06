package com.example.pruebagopass.network

import com.example.pruebagopass.UserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestApiService {
    fun addUser(userInfo: UserInfo, onResult: (UserInfo?) -> Unit) {
        val retrofit = ServiceBuilder.buildService(RestApi::class.java)
        retrofit.addUser(userInfo).enqueue(
            object : Callback<UserInfo> {
                override fun onFailure(call: Call<UserInfo>, t: Throwable) {
                    onResult(null)
                }

                override fun onResponse(call: Call<UserInfo>, response: Response<UserInfo>) {
                    val addedUser = response.body()
                    onResult(addedUser)
                }

            }
        )
    }

}