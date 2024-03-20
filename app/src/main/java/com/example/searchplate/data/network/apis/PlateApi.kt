package com.example.searchplate.data.network.apis

import com.example.searchplate.data.network.models.ResponseDto
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlateApi {

    @POST("AutoOnlineProd/Utils/validaMatricuIaAjax.jsp")
    @FormUrlEncoded
    suspend fun getVinByPlate (
        @Field("plate")plate: String,
        @Field("nome_requerente")nomeRequerente: String,
        @Field("email_requerente")emailRequerente: String,
    ): ResponseDto
}