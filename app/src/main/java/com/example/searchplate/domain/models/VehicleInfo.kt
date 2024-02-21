package com.example.searchplate.domain.models

data class VehicleInfo(
    val brand: String,
    val plate: String,
    val vin: String,
    val vehicleType: String,
    val value: Double,
    val taxValue: Double,
    val totalValue: Double
)
