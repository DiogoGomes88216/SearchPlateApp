package com.example.searchplate.data

import com.example.searchplate.data.network.apis.PlateApi
import com.example.searchplate.data.network.apis.VinApi
import com.example.searchplate.data.network.models.requests.InfoRequestDto
import com.example.searchplate.domain.mappers.VehicleInfoMapper.toVehicleInfo
import com.example.searchplate.domain.models.VehicleInfo
import com.example.searchplate.util.Constants.EMAIL_REQUERENTE
import com.example.searchplate.util.Constants.LANG
import com.example.searchplate.util.Constants.NOME_REQUERENTE
import com.example.searchplate.util.Constants.TOKEN
import com.example.searchplate.util.Constants.VERSION
import com.example.searchplate.util.Constants.VINVALIDATOR
import javax.inject.Inject

class InfoRepository @Inject constructor(
    private val plateApi: PlateApi,
    private val vinApi: VinApi,
){
    suspend fun getVehicleInfoByPlate(plate: String): Result<VehicleInfo> {

        return try {
            val data = plateApi.getVinByPlate(
                plate = plate,
                nomeRequerente = NOME_REQUERENTE,
                emailRequerente = EMAIL_REQUERENTE
            )
            if(data.msg == null)
                //Result.success(data.values.toVehicleInfo())
                getVehicleInfoByVin(data.values.vin)
            else
                Result.failure(Throwable(data.msg.substringAfter("</b>")))

        }catch (ex: Exception){
            Result.failure(ex)
        }
    }

    suspend fun getVehicleInfoByVin(vin: String): Result<VehicleInfo> {
        val infoRequest = InfoRequestDto(
            lang = LANG,
            version = VERSION,
            vinValidator = VINVALIDATOR,
            token = TOKEN,
            vin = vin,
        )

        return try {
            val data = vinApi.getVehicleInfoByVin(infoRequest)
            if(data.status == "ok")
                Result.success(data.result.toVehicleInfo())
            else
                Result.failure(Throwable(data.message))

        }catch (ex: Exception){
            Result.failure(ex)
        }
    }
}