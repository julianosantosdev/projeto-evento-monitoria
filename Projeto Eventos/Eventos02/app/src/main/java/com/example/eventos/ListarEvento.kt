package com.example.eventos

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class ListarEvento : AppCompatActivity() {
    
    private lateinit var adapter: EventoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar_evento)

        val btnSair = findViewById<Button>(R.id.btnSair)
        val btnCriar = findViewById<Button>(R.id.btnCriar)

        val listadeevento = findViewById<RecyclerView>(R.id.listaEventos)
        adapter = EventoAdapter()
        listadeevento.adapter = adapter

        btnSair.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnCriar.setOnClickListener {
            val intent = Intent(this, CriarEvento::class.java)
            startActivity(intent)
        }
    }


}