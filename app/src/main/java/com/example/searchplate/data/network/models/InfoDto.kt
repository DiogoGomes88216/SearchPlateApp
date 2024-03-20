package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class InfoDto(
    @SerializedName("message")
    val message: String,
    @SerializedName("result")
    val result: ResultDto,
    @SerializedName("status")
    val status: String
)