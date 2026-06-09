package com.example.eventos

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.eventos.databinding.ActivityEditarEventoBinding

class EditarEvento : AppCompatActivity() {
    private lateinit var binding: ActivityEditarEventoBinding
    private val viewModel: EventoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditarEventoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        android.util.Log.d(
            "EDITAR",
            "ID recebido = ${intent.getStringExtra("EVENTO_ID")}"
        )

        val id = intent.getStringExtra("EVENTO_ID")

        val evento = id?.let {
            viewModel.buscarPorId(it)
        }

        val spinerEvento = binding.spinnerTipo
        val titulo = binding.ettituloevento
        val dataevento = binding.data
        val horaEvento = binding.hora
        val localevento = binding.local
        val descricaoevento = binding.descricao
        val valorevento = binding.valorDoEvento
        val palestra = binding.palestrante
        val btnVoltar = binding.btnVoltarLista
        val btnSalvar = binding.btnSalvarEvento

        btnVoltar.setOnClickListener {
            finish()
        }

        evento?.let {
            titulo.setText(it.titulo)
            dataevento.setText(it.data)
            horaEvento.setText(it.hora)
            localevento.setText(it.local)
            descricaoevento.setText(it.descricao)
            valorevento.setText(it.valor)
            palestra.setText(it.palestrante)
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Festivais", "Palestras", "Excursões")
        )

        spinerEvento.adapter = adapter

        val posicao = adapter.getPosition(evento?.tipo)
        spinerEvento.setSelection(posicao)

        spinerEvento.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val tipoSelecionado = spinerEvento.selectedItem.toString()

                if (tipoSelecionado == "Palestras") {
                    binding.layoutPalestrante.visibility = View.VISIBLE
                } else {
                    binding.layoutPalestrante.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        btnSalvar.setOnClickListener {
            if (titulo.text.isEmpty()) {
                titulo.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if (dataevento.text.isEmpty()) {
                dataevento.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if (horaEvento.text.isEmpty()) {
                horaEvento.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if (localevento.text.isEmpty()) {
                localevento.error = "Campo obrigatório"
                return@setOnClickListener
            }

            if (valorevento.text.isEmpty()) {
                valorevento.error = "Campo obrigatório"
                return@setOnClickListener
            }

            val eventoAtualizado =
                EventoModel(
                    id = evento!!.id,
                    tipo = spinerEvento.selectedItem.toString(),
                    titulo = titulo.text.toString(),
                    data = dataevento.text.toString(),
                    hora = horaEvento.text.toString(),
                    local = localevento.text.toString(),
                    descricao = descricaoevento.text.toString(),
                    valor = valorevento.text.toString(),
                    palestrante = palestra.text.toString()
                )

            viewModel.atualizarEvento(eventoAtualizado)
            android.widget.Toast.makeText(
                this,
                "Evento salvo",
                android.widget.Toast.LENGTH_SHORT
            ).show()
            finish()
        }


    }
}