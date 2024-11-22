package com.example.logicaquestions

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val pontuacao = intent.getIntExtra("PONTUACAO", 0)
        val tvPontuacao: TextView = findViewById(R.id.tvPontuacao)
        tvPontuacao.text = "Sua pontuação: $pontuacao"

        val tvNivelConhecimento: TextView = findViewById(R.id.tvNivelConhecimento)
        tvNivelConhecimento.text = getNivelConhecimento(pontuacao)

        val btnRefazerQuiz: Button = findViewById(R.id.btnRefazerQuiz)
        btnRefazerQuiz.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        val btnMostrarPerguntas: Button = findViewById(R.id.btnMostrarPerguntas)
        btnMostrarPerguntas.setOnClickListener {
            val intent = Intent(this, PerguntasRespostasActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getNivelConhecimento(pontuacao: Int): String {
        return when (pontuacao) {
            in 9..10 -> "Conhecimento Muito bom em Programação!"
            in 7..8 -> "Conhecimento bom mas tem pontos que devem melhorar"
            else -> "Precisa estudar mais e voltar para fazer o teste novamente"
        }
    }
}