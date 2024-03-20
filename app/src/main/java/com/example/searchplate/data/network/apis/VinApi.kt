package com.example.searchplate.data.network.apis

import com.example.searchplate.data.network.models.InfoDto
import com.example.searchplate.data.network.models.requests.InfoRequestDto
import retrofit2.http.Body
import retrofit2.http.POST

interface VinApi {

    @POST("api/startUp")
    suspend fun getVehicleInfoByVin (@Body request: InfoRequestDto): InfoDto
}