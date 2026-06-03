package com.example.eventos

data class EventoModel(
    val titulo: String,
    val tipo: String,
    val data: String,
    val hora: String,
    val local: String,
    val descricao: String,
    val palestrante: String? = "Não se aplica",
    val valor: String? = "Grátis",
)
