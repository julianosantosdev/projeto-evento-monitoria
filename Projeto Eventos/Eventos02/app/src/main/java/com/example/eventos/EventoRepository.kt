package com.example.eventos

object EventoRepository {
    private val eventos = mutableListOf<EventoModel>()

    fun adicionarEvento(evento: EventoModel) {
        eventos.add(evento)
    }

    fun listarEventos(): List<EventoModel> {
        return eventos
    }

    fun removerEvento(evento: EventoModel) {
        eventos.remove(evento)
    }
}        