package com.example.pruebagopass

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("numeroIdentificacion") val userId: Int?,
    @SerializedName("nombres") val names: String?,
    @SerializedName("apellidos") val lastNames: String?,
    @SerializedName("telefonoMovil") val phone: String?,
    @SerializedName("correo") val mail: String?,
    @SerializedName("cuenta") val account: String?,
    @SerializedName("tipodocumento") val documentType: String?,
    @SerializedName("key") val key: String?,
    @SerializedName("tokenPush") val token: String?,
    @SerializedName("genero") val genre: String?
)