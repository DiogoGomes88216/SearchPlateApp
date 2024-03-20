package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class EmissionStd(
    @SerializedName("co2_gkm")
    val co2Gkm: String,
    @SerializedName("desc")
    val desc: String,
    @SerializedName("value")
    val value: String?
)