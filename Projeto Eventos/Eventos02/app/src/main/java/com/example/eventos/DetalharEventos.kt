package com.example.eventos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventos.databinding.ActivityDetalharEventosBinding

class DetalharEventos : AppCompatActivity() {
    private lateinit var binding: ActivityDetalharEventosBinding
    private val viewModel: EventoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalharEventosBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.btnVoltarDetalhes.setOnClickListener {
            finish()
        }

        val id = intent.getStringExtra("EVENTO_ID")

        val evento = id?.let {
            viewModel.buscarPorId(id)
        }

        evento?.let { it ->

            binding.txtTitulo.text = it.titulo.toString()
            binding.txtTipo.text = it.tipo
            binding.txtData.text = it.data
            binding.txtHora.text = it.hora
            binding.txtLocal.text = it.local
            binding.txtDescricao.text = it.descricao
            binding.txtValor.text = it.valor
            binding.txtPalestrante.text = it.palestrante
        }

        binding.btnEditarEvento.setOnClickListener {
            val intent =
                Intent(this, EditarEvento::class.java)

            intent.putExtra(
                "EVENTO_ID",
                id
            )

            startActivity(intent)
            finish()
        }
    }
}