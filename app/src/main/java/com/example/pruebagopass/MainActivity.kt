package com.example.pruebagopass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pruebagopass.network.RestApi.RestApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllEstablishments()

    }

    fun getAllEstablishments() {
        RestApiService.retrofitService.getAllEstablishment().enqueue( object: retrofit2.Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                text.text = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                text.text = response.body()
            }
        })
    }
}