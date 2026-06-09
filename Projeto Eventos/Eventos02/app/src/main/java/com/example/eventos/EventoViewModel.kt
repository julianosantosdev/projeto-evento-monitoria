package com.example.eventos

import androidx.lifecycle.ViewModel

class EventoViewModel : ViewModel() {

    fun adicionarEvento(evento: EventoModel) {
        EventoRepository.adicionarEvento(evento)
    }

    fun listarEventos(): List<EventoModel> {
        return EventoRepository.listarEventos()
    }

    fun buscarPorId(id: String): EventoModel? {
        return EventoRepository.buscarPorId(id)
    }

    fun atualizarEvento(evento: EventoModel) {
        EventoRepository.atualizarEvento(evento)
    }

    fun removerEvento(id: String) {
        EventoRepository.removerEvento(id)
    }
}