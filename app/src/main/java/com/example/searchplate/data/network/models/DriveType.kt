package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class DriveType(
    @SerializedName("desc")
    val desc: String,
    @SerializedName("value")
    val value: String?
)