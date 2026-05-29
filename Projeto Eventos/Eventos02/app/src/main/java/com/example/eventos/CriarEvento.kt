package com.example.eventos

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CriarEvento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_criar_evento)

        val spinerEvento = findViewById<Spinner>(R.id.spinnerTipo)


        //modal String
        val tipo = findViewById<Spinner>(R.id.spinnerTipo)
        val titulo = findViewById<EditText>(R.id.ettituloevento)
        val dataevento = findViewById<EditText>(R.id.data)
        val horaEvento = findViewById<EditText>(R.id.hora)
        val localevento = findViewById<EditText>(R.id.local)
        val descricaoevento = findViewById<EditText>(R.id.descricao)
        val valorevento = findViewById<EditText>(R.id.valorDoEvento)
        val palestra = findViewById<EditText>(R.id.palestrante)
        val btnVoltar = findViewById<Button>(R.id.btnVoltarLista)
        val btnSalvar = findViewById<Button>(R.id.btnSalvarEvento)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            listOf("Festivais", "Palaestras", "Excursões")
        )
        spinerEvento.adapter = adapter



        btnVoltar.setOnClickListener {
            val intent = Intent(this, ListarEvento::class.java)
            startActivity(intent)
        }



        btnSalvar.setOnClickListener {
            val evento =
                EventoModel(
                    tipo = tipo.selectedItem.toString(),
                    titulo = titulo.text.toString(),
                    data = dataevento.text.toString(),
                    hora = horaEvento.text.toString(),
                    local = localevento.text.toString(),
                    descricao = descricaoevento.text.toString(),
                    valor = valorevento.text.toString(),
                    palestrante = palestra.text.toString()
                )

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

            if (palestra.text.isEmpty()) {
                palestra.error = "Campo obrigatório"
                return@setOnClickListener
            }

            EventoAdapter.addEvento(evento)
            //finish()
        }

    }

}
