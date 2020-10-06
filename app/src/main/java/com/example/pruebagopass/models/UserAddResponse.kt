package com.example.pruebagopass.models

import com.squareup.moshi.Json

data class UserAddResponse (
    @Json(name = "return") var success: Boolean?,
    var data: UserInfo?,
    var message: String?,
    var messages: Any?
)