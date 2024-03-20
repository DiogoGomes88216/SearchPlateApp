package com.example.searchplate.data.network.models


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ResponseDto(
    @SerializedName("msg")
    val msg: String,
    @SerializedName("celebracaoContrato")
    val celebracaoContrato: Boolean,
    @SerializedName("documentos")
    val documentos: List<Any>,
    @SerializedName("erroMatricula")
    val erroMatricula: Boolean,
    @SerializedName("intervenientes")
    val intervenientes: List<Any>,
    @SerializedName("noTrasmissaoPropriedade")
    val noTrasmissaoPropriedade: Boolean,
    @SerializedName("requerenteIdoneidade")
    val requerenteIdoneidade: Boolean,
    @SerializedName("snapshotVersion")
    val snapshotVersion: Long,
    @SerializedName("suprimentos")
    val suprimentos: List<Any>,
    @SerializedName("values")
    val values: ValuesDto,
    @SerializedName("veiculoOwner")
    val veiculoOwner: Boolean
)