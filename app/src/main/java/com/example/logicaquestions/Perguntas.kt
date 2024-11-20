package com.example.logicaquestions

data class Perguntas(
    val id: Int,
    val titulo: String,
    val imagem: Int,
    val respostas: List<String>,
    val respostaCerta: Int,
    val justificativa: String
)

fun validarResposta(pergunta: Perguntas, respostaUsuario: Int): Boolean {
    return respostaUsuario == pergunta.respostaCerta
}