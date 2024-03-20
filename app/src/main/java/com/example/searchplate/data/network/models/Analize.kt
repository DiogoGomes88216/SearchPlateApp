package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Analize(
    @SerializedName("checkdigit")
    val checkdigit: Checkdigit,
    @SerializedName("vin_corrected")
    val vinCorrected: VinCorrected,
    @SerializedName("vin_orginal")
    val vinOrginal: VinOrginal,
    @SerializedName("vin_serial")
    val vinSerial: VinSerial,
    @SerializedName("vin_year")
    val vinYear: VinYear
)