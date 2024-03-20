package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Decoder(
    @SerializedName("analize")
    val analize: Analize,
    @SerializedName("custom_equipment")
    val customEquipment: CustomEquipment,
    @SerializedName("manufacturer")
    val manufacturer: Manufacturer,
    @SerializedName("vehicle")
    val vehicle: Vehicle
)