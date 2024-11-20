package com.example.logicaquestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptacaoPerguntas(private val perguntasList: List<Perguntas>) :
    RecyclerView.Adapter<AdaptacaoPerguntas.PerguntasViewHolder>() {

    private val respostasSelecionadas = mutableMapOf<Int, Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerguntasViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_pergunta, parent, false)
        return PerguntasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PerguntasViewHolder, position: Int) {
        val pergunta = perguntasList[position]
        holder.tvTitulo.text = pergunta.titulo
        holder.ivImagem.setImageResource(pergunta.imagem)

        holder.rgRespostas.removeAllViews()
        pergunta.respostas.forEachIndexed { index, resposta ->
            val radioButton = RadioButton(holder.itemView.context)
            radioButton.id = index
            radioButton.text = resposta
            holder.rgRespostas.addView(radioButton)
        }

        holder.rgRespostas.setOnCheckedChangeListener { _, checkedId ->
            respostasSelecionadas[pergunta.id] = checkedId
        }
    }

    override fun getItemCount() = perguntasList.size

    fun getSelectedAnswer(perguntaId: Int): Int? {
        return respostasSelecionadas[perguntaId]
    }

    class PerguntasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTitulo)
        val ivImagem: ImageView = itemView.findViewById(R.id.ivImagem)
        val rgRespostas: RadioGroup = itemView.findViewById(R.id.rgRespostas)
    }
}