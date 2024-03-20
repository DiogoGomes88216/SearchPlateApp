package com.example.searchplate.domain.models

import android.graphics.Bitmap

data class VehicleInfo(
    val vin: String?,
    val body: String?,
    val doors: String?,
    val driveType: String?,
    val emissionStd: String?,
    val engineConf: String?,
    val engineCylinders: String?,
    val engineDisplCid: String?,
    val engineDisplCm3: String?,
    val engineDisplL: String?,
    val engineHead: String?,
    val enginePowerHp: String?,
    val enginePowerKw: String?,
    val engineTurbo: String?,
    val engineType: String?,
    val engineValves: String?,
    val engineVersion: String?,
    val fuelType: String?,
    val gearboxType: String?,
    val make: String?,
    val model: String?,
    val modelYear: String?,
    val vehicleType: String?,
    val logo: Bitmap?,
)

