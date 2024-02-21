package com.example.searchplate.data

import com.example.searchplate.domain.mappers.VehicleInfoMapper.toVehicleInfo
import com.example.searchplate.domain.models.VehicleInfo
import com.example.searchplate.util.Constants.EMAIL_REQUERENTE
import com.example.searchplate.util.Constants.NOME_REQUERENTE
import javax.inject.Inject

class VinRepository @Inject constructor(
    private val api: VinApi,
){

    suspend fun getVehicleInfoByPlate(plate: String): Result<VehicleInfo> {

        return try {
            val data = api.getVehicleInfoByPlate(
                plate = plate,
                nomeRequerente = NOME_REQUERENTE,
                emailRequerente = EMAIL_REQUERENTE
            )
            Result.success(data.values.toVehicleInfo())

        }catch (ex: Exception){
            Result.failure(ex)
        }
    }
}