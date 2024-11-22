package com.example.logicaquestions

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES) // NÃO CONSEGUI ARRUMAR O CODIGO LIGHT PARA FICAR IGUAL O NIGHT ENTÃO SO VAI USAR O NIGHT.
        setContentView(R.layout.activity_main)

        val btnLogo: ImageButton = findViewById(R.id.btnLogo)
        btnLogo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LuigiGC?tab=repositories"))
            startActivity(intent)
        }

        val btnIniciarQuiz: Button = findViewById(R.id.btnIniciarQuiz)
        btnIniciarQuiz.setOnClickListener {
            val intent = Intent(this, PerguntaActivity::class.java)
            intent.putExtra("PERGUNTA_INDEX", 0)
            startActivity(intent)
        }
    }
}