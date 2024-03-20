package com.example.searchplate.domain.mappers

import android.graphics.BitmapFactory
import android.util.Base64
import com.example.searchplate.data.network.models.ResultDto
import com.example.searchplate.data.network.models.ValuesDto
import com.example.searchplate.domain.mappers.VehicleInfoMapper.toVehicleInfo
import com.example.searchplate.domain.models.VehicleInfo

object VehicleInfoMapper {

    fun ValuesDto.toVehicleInfo() = VehicleInfo(
        vin = vin,
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
        make = make,
        model = "",
        modelYear = "",
        vehicleType = "",
        logo = null,
    )

    fun ResultDto.toVehicleInfo() : VehicleInfo{

        val imageBytes = Base64.decode(logo, Base64.DEFAULT)
        val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

        return VehicleInfo(
            vin = decoder.analize.vinCorrected.value,
            body = decoder.vehicle.body.value,
            doors = decoder.vehicle.doors.value,
            driveType = decoder.vehicle.driveType.value,
            emissionStd = decoder.vehicle.emissionStd.value,
            engineConf = decoder.vehicle.engineConf.value.toString(),
            engineCylinders = decoder.vehicle.engineCylinders.value,
            engineDisplCid = decoder.vehicle.engineDisplCid.value,
            engineDisplCm3 = decoder.vehicle.engineDisplCm3.value,
            engineDisplL = decoder.vehicle.engineDisplL.value,
            engineHead = decoder.vehicle.engineHead.value,
            enginePowerHp = decoder.vehicle.enginePowerHp.value,
            enginePowerKw = decoder.vehicle.enginePowerKw.value,
            engineTurbo = decoder.vehicle.engineTurbo.value,
            engineType = decoder.vehicle.engineType.value,
            engineValves = decoder.vehicle.engineValves.value,
            engineVersion = decoder.vehicle.engineType.value,
            fuelType = decoder.vehicle.fuelType.value,
            gearboxType = decoder.vehicle.gearboxType.value,
            make = decoder.vehicle.make.value,
            model = decoder.vehicle.model.value,
            modelYear = decoder.vehicle.modelYear.value.toString(),
            vehicleType = decoder.vehicle.vehicleType.value,
            logo = decodedImage,
        )
    }

}