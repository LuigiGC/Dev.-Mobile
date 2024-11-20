package com.example.logicaquestions

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val pontuacao = intent.getIntExtra("PONTUACAO", 0)
        val tvPontuacao: TextView = findViewById(R.id.tvPontuacao)
        tvPontuacao.text = "Sua pontuação: $pontuacao"

        val tvNivelConhecimento: TextView = findViewById(R.id.tvNivelConhecimento)
        tvNivelConhecimento.text = getNivelConhecimento(pontuacao)
    }

    private fun getNivelConhecimento(pontuacao: Int): String {
        return when (pontuacao) {
            in 9..10 -> "Conhecimento Muito bom em Programação!"
            in 7..8 -> "Conhecimento bom mas tem pontos que devem melhorar"
            else -> "Precisa estudar mais e voltar para fazer o teste novamente"
        }
    }
}