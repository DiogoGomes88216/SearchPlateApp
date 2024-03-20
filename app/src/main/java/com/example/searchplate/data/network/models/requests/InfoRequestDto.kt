package com.example.searchplate.data.network.models.requests


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class InfoRequestDto(
    @SerializedName("lang")
    val lang: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("version")
    val version: String,
    @SerializedName("vin")
    val vin: String,
    @SerializedName("vinValidator")
    val vinValidator: Boolean
)