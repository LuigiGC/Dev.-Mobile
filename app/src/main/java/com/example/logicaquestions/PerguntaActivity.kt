package com.example.logicaquestions

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerguntaActivity : AppCompatActivity() {

    private lateinit var pergunta: Perguntas
    private var perguntaIndex: Int = 0
    private lateinit var perguntasList: List<Perguntas>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta)

        perguntaIndex = intent.getIntExtra("PERGUNTA_INDEX", 0)
        perguntasList = Constante.questoes()
        pergunta = perguntasList[perguntaIndex]

        val tvTitulo: TextView = findViewById(R.id.tvTitulo)
        val ivImagem: ImageView = findViewById(R.id.ivImagem)
        val rgRespostas: RadioGroup = findViewById(R.id.rgRespostas)
        val btnResponder: Button = findViewById(R.id.btnResponder)

        tvTitulo.text = pergunta.titulo
        ivImagem.setImageResource(pergunta.imagem)

        pergunta.respostas.forEachIndexed { index, resposta ->
            val radioButton = RadioButton(this)
            radioButton.id = index
            radioButton.text = resposta
            rgRespostas.addView(radioButton)
        }

        btnResponder.setOnClickListener {
            val selectedId = rgRespostas.checkedRadioButtonId
            if (selectedId != -1) {
                val isCorrect = selectedId == pergunta.respostaCerta
                if (isCorrect) {
                    btnResponder.setBackgroundColor(Color.GREEN)
                } else {
                    btnResponder.setBackgroundColor(Color.RED)
                }

                // Armazena a resposta e navega para a próxima pergunta
                // Aqui você pode armazenar a resposta em uma lista ou banco de dados
                if (perguntaIndex < perguntasList.size - 1) {
                    val intent = Intent(this, PerguntaActivity::class.java)
                    intent.putExtra("PERGUNTA_INDEX", perguntaIndex + 1)
                    startActivity(intent)
                } else {
                    // Navega para a tela de resultado
                    val intent = Intent(this, Resultado::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}