package com.example.logicaquestions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PerguntasRespostasAdapter(private val perguntasList: List<Perguntas>) :
    RecyclerView.Adapter<PerguntasRespostasAdapter.PerguntasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerguntasViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_pergunta_resposta, parent, false)
        return PerguntasViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PerguntasViewHolder, position: Int) {
        val pergunta = perguntasList[position]
        holder.tvTitulo.text = pergunta.titulo
        holder.ivImagem.setImageResource(pergunta.imagem)
        holder.tvJustificativa.text ="Justificativa: ${pergunta.justificativa}"

        val respostas = pergunta.respostas.mapIndexed { index, resposta ->
            if (index == pergunta.respostaCerta) {
                "<font color='#00FF00'>$resposta</font>"
            } else {
                "<font color='#FF0000'>$resposta</font>"
            }
        }.joinToString("<br>")

        holder.tvRespostas.text = android.text.Html.fromHtml(respostas)
    }

    override fun getItemCount() = perguntasList.size



    class PerguntasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tvTituloPR)
        val ivImagem: ImageView = itemView.findViewById(R.id.ivImagemPergunta)
        val tvRespostas: TextView = itemView.findViewById(R.id.tvRespostas)
        val tvJustificativa: TextView = itemView.findViewById(R.id.tvJustificativa)
    }
}