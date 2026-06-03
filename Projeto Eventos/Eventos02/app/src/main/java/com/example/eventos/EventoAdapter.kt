package com.example.eventos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventoAdapter(private val onItemClick: (EventoModel) -> Unit) :
    RecyclerView.Adapter<EventoAdapter.EventoViewHoldelder>() {
    private var listaDeEventos = listOf<EventoModel>()

    fun atualizarLista(eventos: List<EventoModel>) {
        listaDeEventos = eventos
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventoViewHoldelder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.evento_layout, parent, false)
        return EventoViewHoldelder(view)
    }

    override fun onBindViewHolder(holder: EventoViewHoldelder, position: Int) {
        val evento = listaDeEventos[position]

        holder.bind(evento)

        holder.itemView.setOnClickListener {
            onItemClick(evento)
        }
    }

    override fun getItemCount(): Int {
        return listaDeEventos.size
    }

    class EventoViewHoldelder(view: View) : RecyclerView.ViewHolder(view) {

        val titulo = view.findViewById<TextView>(R.id.eventoTitulo)
        val data = view.findViewById<TextView>(R.id.eventoData)


        fun bind(evento: EventoModel) {
            // caso precise de mais campos, mudar no evento_layout e adicionar aqui também.
            titulo.text = evento.titulo
            data.text = evento.data
        }
    }
}