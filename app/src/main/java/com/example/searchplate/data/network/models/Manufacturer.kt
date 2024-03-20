package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Manufacturer(
    @SerializedName("adress_1")
    val adress1: Adress1,
    @SerializedName("adress_2")
    val adress2: Adress1,
    @SerializedName("country")
    val country: Country,
    @SerializedName("name")
    val name: Name,
    @SerializedName("note")
    val note: Note,
    @SerializedName("region")
    val region: Region
)