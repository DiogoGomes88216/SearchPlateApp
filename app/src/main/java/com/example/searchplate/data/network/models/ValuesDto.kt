package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ValuesDto(
    @SerializedName("marca")
    val brand: String,
    @SerializedName("matricula")
    val plate: String,
    @SerializedName("numQuadro")
    val vin: String,
    @SerializedName("tipoVeiculo")
    val vehicleType: String,
    @SerializedName("valor")
    val value: Double,
    @SerializedName("valorImpostoSelo")
    val taxValue: Double,
    @SerializedName("valorTotal")
    val totalValue: Double
)