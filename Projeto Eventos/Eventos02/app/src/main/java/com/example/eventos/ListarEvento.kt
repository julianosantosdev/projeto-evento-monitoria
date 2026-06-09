package com.example.eventos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eventos.databinding.ActivityListarEventoBinding

class ListarEvento : AppCompatActivity() {
    private val viewModel: EventoViewModel by viewModels()
    private lateinit var adapter: EventoAdapter
    private lateinit var binding: ActivityListarEventoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarEventoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val btnSair = binding.btnSair
        val btnCriar = binding.btnCriar

        val listaDeEventos = binding.recycleViewListaEventos

        adapter = EventoAdapter(
            onItemClick = { evento ->

                val intent =
                    Intent(this, DetalharEventos::class.java)

                intent.putExtra("EVENTO_ID", evento.id)

                startActivity(intent)
            },

            onDeleteClick = { evento ->
                AlertDialog.Builder(this)
                    .setTitle("Excluir evento")
                    .setMessage("Deseja realmente excluir este evento?")
                    .setPositiveButton("Sim") { _, _ ->

                        viewModel.removerEvento(evento.id)

                        adapter.atualizarLista(
                            viewModel.listarEventos()
                        )
                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            }
        )


        listaDeEventos.layoutManager = LinearLayoutManager(this)
        listaDeEventos.adapter = adapter

        btnSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCriar.setOnClickListener {
            val intent = Intent(this, CriarEvento::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()

        adapter.atualizarLista(
            viewModel.listarEventos()
        )
    }


}