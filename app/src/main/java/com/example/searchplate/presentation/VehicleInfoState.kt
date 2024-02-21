package com.example.searchplate.presentation

import com.example.searchplate.domain.models.VehicleInfo

data class VehicleInfoState(
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val error: Throwable? = null,
    val info: VehicleInfo = VehicleInfo(
        brand = "",
        plate = "",
        vin = "",
        vehicleType = "",
        value =  0.0,
        taxValue = 0.0,
        totalValue = 0.0
    ),
    val searchQuery: String = ""
)
