package com.example.logicaquestions

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerguntaActivity : AppCompatActivity() {

    private lateinit var pergunta: Perguntas
    private var perguntaIndex: Int = 0
    private lateinit var perguntasList: List<Perguntas>
    private var pontuacao: Int = 0
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pergunta)

        perguntaIndex = intent.getIntExtra("PERGUNTA_INDEX", 0)
        pontuacao = intent.getIntExtra("PONTUACAO", 0)
        perguntasList = Constante.questoes()
        pergunta = perguntasList[perguntaIndex]

        val tvTitulo: TextView = findViewById(R.id.tvTitulo)
        val ivImagem: ImageView = findViewById(R.id.ivImagem)
        val rgRespostas: RadioGroup = findViewById(R.id.rgRespostas)
        val btnResponder: Button = findViewById(R.id.btnResponder)
        progressBar = findViewById(R.id.progressBar)

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
                    pontuacao++
                } else {
                    btnResponder.setBackgroundColor(Color.RED)
                }
                countDownTimer.cancel()
                navigateToNextQuestion()
            }
        }

        startTimer()
    }

    private fun startTimer() {
        progressBar.max = 40
        countDownTimer = object : CountDownTimer(40000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val progress = (40000 - millisUntilFinished) / 1000
                progressBar.progress = progress.toInt()
            }

            override fun onFinish() {
                progressBar.progress = 40
                navigateToNextQuestion()
            }
        }.start()
    }

    private fun navigateToNextQuestion() {
        if (perguntaIndex < perguntasList.size - 1) {
            val intent = Intent(this, PerguntaActivity::class.java)
            intent.putExtra("PERGUNTA_INDEX", perguntaIndex + 1)
            intent.putExtra("PONTUACAO", pontuacao)
            startActivity(intent)
            finish() // Fecha a Activity atual
        } else {
            val intent = Intent(this, Resultado::class.java)
            intent.putExtra("PONTUACAO", pontuacao)
            startActivity(intent)
            finish() // Fecha a Activity atual
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }
}