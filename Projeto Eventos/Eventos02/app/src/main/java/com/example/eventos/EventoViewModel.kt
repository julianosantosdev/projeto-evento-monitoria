package com.example.eventos

import androidx.lifecycle.ViewModel

class EventoViewModel : ViewModel() {

    fun adicionarEvento(evento: EventoModel) {
        EventoRepository.adicionarEvento(evento)
    }

    fun listarEventos(): List<EventoModel> {
        return EventoRepository.listarEventos()
    }

    fun removerEvento(evento: EventoModel) {
        EventoRepository.removerEvento(evento)
    }
}