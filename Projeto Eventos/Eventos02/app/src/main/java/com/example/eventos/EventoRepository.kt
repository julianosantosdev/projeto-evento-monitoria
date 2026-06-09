package com.example.eventos

import java.util.UUID

object EventoRepository {
    private val eventos = mutableListOf(
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Palestras",
            titulo = "Introdução ao Kotlin",
            data = "10/08/2026",
            hora = "19:00",
            local = "Auditório Principal",
            descricao = "Fundamentos da linguagem Kotlin.",
            valor = "0,00",
            palestrante = "Carlos Silva"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Workshop",
            titulo = "Flutter na Prática",
            data = "12/08/2026",
            hora = "14:00",
            local = "Laboratório 2",
            descricao = "Desenvolvimento mobile com Flutter.",
            valor = "50,00",
            palestrante = "Ana Souza"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Curso",
            titulo = "Git e GitHub",
            data = "15/08/2026",
            hora = "09:00",
            local = "Sala 101",
            descricao = "Controle de versão para iniciantes.",
            valor = "30,00",
            palestrante = "João Mendes"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Palestras",
            titulo = "Inteligência Artificial",
            data = "18/08/2026",
            hora = "20:00",
            local = "Auditório Central",
            descricao = "Panorama atual da IA.",
            valor = "0,00",
            palestrante = "Fernanda Costa"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Workshop",
            titulo = "Docker Essencial",
            data = "20/08/2026",
            hora = "18:30",
            local = "Lab DevOps",
            descricao = "Containers na prática.",
            valor = "40,00",
            palestrante = "Rafael Lima"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Curso",
            titulo = "Banco de Dados SQL",
            data = "22/08/2026",
            hora = "08:00",
            local = "Sala 202",
            descricao = "Modelagem e consultas SQL.",
            valor = "60,00",
            palestrante = "Patrícia Alves"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Palestras",
            titulo = "Segurança da Informação",
            data = "25/08/2026",
            hora = "19:30",
            local = "Auditório B",
            descricao = "Boas práticas de segurança.",
            valor = "0,00",
            palestrante = "Ricardo Nunes"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Workshop",
            titulo = "Linux para Desenvolvedores",
            data = "27/08/2026",
            hora = "15:00",
            local = "Lab Linux",
            descricao = "Ferramentas essenciais do Linux.",
            valor = "45,00",
            palestrante = "Marcos Oliveira"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Curso",
            titulo = "Desenvolvimento Android",
            data = "29/08/2026",
            hora = "09:00",
            local = "Sala Mobile",
            descricao = "Android com Kotlin.",
            valor = "80,00",
            palestrante = "Juliana Rocha"
        ),
        EventoModel(
            id = UUID.randomUUID().toString(),
            tipo = "Palestras",
            titulo = "Carreira em Tecnologia",
            data = "30/08/2026",
            hora = "18:00",
            local = "Auditório Principal",
            descricao = "Mercado de trabalho em TI.",
            valor = "0,00",
            palestrante = "Eduardo Martins"
        )
    )

    fun adicionarEvento(evento: EventoModel) {
        eventos.add(evento)
    }

    fun listarEventos(): List<EventoModel> {
        return eventos
    }

    fun buscarPorId(id: String): EventoModel? {
        return eventos.find { it.id == id }
    }

    fun atualizarEvento(eventoAtualizado: EventoModel) {

        val indice = eventos.indexOfFirst {
            it.id == eventoAtualizado.id
        }

        if (indice != -1) {
            eventos[indice] = eventoAtualizado
        }
    }

    fun removerEvento(id: String) {
        eventos.removeIf { it.id == id }
    }
}        