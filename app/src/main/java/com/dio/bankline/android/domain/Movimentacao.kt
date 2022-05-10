package com.dio.bankline.android.domain

data class Movimentacao (
    val id: Int,
    val dataHora: String,
    val descricao: String,
    val valor: Double,
    val tipo: TipoMovimentacao,
    //TODO Mapear idConta -> idCorrentista
    val idCorrentista: Int,
)