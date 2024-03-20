package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ResultDto(
    @SerializedName("decoder")
    val decoder: Decoder,
    @SerializedName("logo")
    val logo: String
)