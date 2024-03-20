package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Vehicle(
    @SerializedName("body")
    val body: Body,
    @SerializedName("doors")
    val doors: Doors,
    @SerializedName("drive_type")
    val driveType: DriveType,
    @SerializedName("emission_std")
    val emissionStd: EmissionStd,
    @SerializedName("engine_conf")
    val engineConf: EngineConf,
    @SerializedName("engine_cylinders")
    val engineCylinders: EngineCylinders,
    @SerializedName("engine_displ_cid")
    val engineDisplCid: EngineDisplCid,
    @SerializedName("engine_displ_cm3")
    val engineDisplCm3: EngineDisplCm3,
    @SerializedName("engine_displ_l")
    val engineDisplL: EngineDisplL,
    @SerializedName("engine_head")
    val engineHead: EngineHead,
    @SerializedName("engine_power_hp")
    val enginePowerHp: EnginePowerHp,
    @SerializedName("engine_power_kw")
    val enginePowerKw: EnginePowerKw,
    @SerializedName("engine_turbo")
    val engineTurbo: EngineTurbo,
    @SerializedName("engine_type")
    val engineType: EngineType,
    @SerializedName("engine_valves")
    val engineValves: EngineValves,
    @SerializedName("engine_version")
    val engineVersion: EngineVersion,
    @SerializedName("fuel_type")
    val fuelType: FuelType,
    @SerializedName("gearbox_type")
    val gearboxType: GearboxType,
    @SerializedName("make")
    val make: Make,
    @SerializedName("model")
    val model: Model,
    @SerializedName("model_year")
    val modelYear: ModelYear,
    @SerializedName("vehicle_type")
    val vehicleType: VehicleType
)