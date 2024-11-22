package com.example.logicaquestions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PerguntasRespostasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perguntas_respostas)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewPerguntas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PerguntasRespostasAdapter(Constante.questoes())
    }
}