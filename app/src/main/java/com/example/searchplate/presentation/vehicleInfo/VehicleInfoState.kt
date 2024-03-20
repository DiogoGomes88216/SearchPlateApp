package com.example.searchplate.presentation.vehicleInfo

import com.example.searchplate.domain.models.VehicleInfo

data class VehicleInfoState(
    val isLoading: Boolean = true,
    val hasError: Boolean = false,
    val error: Throwable? = null,
    val info: VehicleInfo = VehicleInfo(
        vin = "",
        body = "",
        doors = "",
        driveType = "",
        emissionStd = "",
        engineConf = "",
        engineCylinders = "",
        engineDisplCid = "",
        engineDisplCm3 = "",
        engineDisplL = "",
        engineHead = "",
        enginePowerHp = "",
        enginePowerKw = "",
        engineTurbo = "",
        engineType = "",
        engineValves = "",
        engineVersion = "",
        fuelType = "",
        gearboxType = "",
        make = "",
        model = "",
        modelYear = "",
        vehicleType = "",
        logo = null,
    ),
    val searchQuery: String = ""
)
