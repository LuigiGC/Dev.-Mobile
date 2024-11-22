package com.example.logicaquestions

object Constante {

    fun questoes(): ArrayList<Perguntas> {
        val listaDePerguntas = ArrayList<Perguntas>()

        val pergunta1 = Perguntas(
            1,
            "Em Python, Qual é a saída do código da imagem?",
            R.drawable.pergunta1,
            listOf("1", "2", "3", "IndexError", "None"),
            2,
           "O índice -1 em listas do Python acessa o último elemento da lista. Logo, o valor de x[-1] é 3"
        )
        listaDePerguntas.add(pergunta1)

        val pergunta2 = Perguntas(
            2,
            "Qual opção demonstra corretamente como declarar uma variável em Kotlin?",
            R.drawable.pergunta2,
            listOf("var myVariable: String = \"Hello\"","string myVariable = \"Hello\";","myVariable String: \"Hello\";","String myVariable = \"Hello\";","myVariable := \"Hello\";"),
            0,
            "Em Kotlin, o uso de var (variável mutável) ou val (variável imutável) seguido do tipo e valor é o formato correto."
        )
        listaDePerguntas.add(pergunta2)

        val pergunta3 = Perguntas(
            3,
            "Em Java, qual palavra-chave é usada para impedir que uma classe seja estendida?",
            R.drawable.pergunta3,
            listOf("protected", "static", "private", "final", "immutable"),
            3,
            "A palavra-chave final em Java impede que uma classe seja estendida, ou seja, ela não pode ser usada como superclasse."
        )
        listaDePerguntas.add(pergunta3)

        val pergunta4 = Perguntas(
            4,
            "No Go, como você cria uma função anônima que retorna a soma de dois números?",
            R.drawable.pergunta4,
            listOf("func(a, b int) { return a + b }", "sum := func(a, b int) int { return a + b }", "sum = func(a, b int): a + b", "anon := func(a, b) { return a + b }", "lambda a, b: a + b"),
            1,
            "No Go, funções anônimas são criadas com a palavra-chave func, e sua sintaxe inclui a atribuição a uma variável."
        )
        listaDePerguntas.add(pergunta4)

        val pergunta5 = Perguntas(
            5,
            "Qual dessas linguagens é estaticamente tipada?",
            R.drawable.pergunta5,
            listOf("Python", "PHP", "JavaScript", "Ruby", "Java"),
            4,
            "Java é uma linguagem estaticamente tipada, o que significa que os tipos das variáveis são verificados em tempo de compilação."
        )
        listaDePerguntas.add(pergunta5)

        val pergunta6 = Perguntas(
            6,
            "No Python, qual é o resultado de:",
            R.drawable.pergunta6,
            listOf("2.5", "3.5", "2", "None", "TypeError"),
            2,
             "O operador // realiza uma divisão inteira, descartando a parte decimal. Portanto, 5 // 2 resulta em 2."
        )
        listaDePerguntas.add(pergunta6)

        val pergunta7 = Perguntas(
            7,
            "Qual é o significado de \"null safety\" no Kotlin?",
            R.drawable.pergunta7,
            listOf("Permitir valores nulos por padrão.", "Garantir que variáveis não nulas nunca contenham valores nulos.", "Um recurso para ignorar valores nulos automaticamente.", "Uma ferramenta de sincronização de threads.", "Uma funcionalidade de acesso a dados seguros."),
            1,
            "Null safety em Kotlin impede que variáveis marcadas como não nulas (non-nullable) recebam valores nulos, reduzindo erros em tempo de execução."
        )
        listaDePerguntas.add(pergunta7)

        val pergunta8 = Perguntas(
            8,
            "Em Go, como você define uma constante?",
            R.drawable.pergunta8,
            listOf("constant Pi = 3.14", "let Pi = 3.14","const Pi float64 = 3.14", "final Pi = 3.14", "immutable Pi = 3.14"),
            2,
            "Em Go, a palavra-chave const é usada para declarar constantes, seguidas pelo nome, tipo e valor."
        )
        listaDePerguntas.add(pergunta8)

        val pergunta9 = Perguntas(
            9,
            "Em Java, qual método é usado para comparar dois objetos?",
            R.drawable.pergunta9,
            listOf("equals()", "compareTo()", "==", "compare()", "isEqual()"),
            0,
            "O método equals() é usado para comparar o conteúdo de dois objetos em Java, enquanto == compara referências na memória."
        )
        listaDePerguntas.add(pergunta9)

        val pergunta10 = Perguntas(
            10,
            "No Python, o que a função len() retorna?",
            R.drawable.pergunta10,
            listOf("A soma de todos os elementos de uma lista.", "O número de elementos de um objeto.", "A memória ocupada por uma variável.", "O tipo de um objeto.", "Um valor booleano."),
            1,
            "A função len() retorna o número de elementos presentes no objeto passado como argumento, como listas, strings ou dicionários."
        )
        listaDePerguntas.add(pergunta10)

        return listaDePerguntas
    }
}