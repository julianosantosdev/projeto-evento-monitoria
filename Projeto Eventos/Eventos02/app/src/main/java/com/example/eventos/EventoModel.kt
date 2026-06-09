package com.example.eventos

import java.util.UUID

data class EventoModel(
    val id: String = UUID.randomUUID().toString(),
    val titulo: String,
    val tipo: String,
    val data: String,
    val hora: String,
    val local: String,
    val descricao: String,
    val palestrante: String? = "Não se aplica",
    val valor: String? = "Grátis",
)
