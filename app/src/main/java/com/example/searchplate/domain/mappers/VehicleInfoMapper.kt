package com.example.searchplate.domain.mappers

import com.example.searchplate.data.network.models.ValuesDto
import com.example.searchplate.domain.models.VehicleInfo

object VehicleInfoMapper {

    fun ValuesDto.toVehicleInfo() = VehicleInfo(
        brand = brand,
        plate = plate,
        vin = vin,
        vehicleType = vehicleType,
        value = value,
        taxValue = taxValue,
        totalValue = totalValue,
    )
}