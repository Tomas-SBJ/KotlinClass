package br.com.alura.gameapi.principal

import br.com.alura.gameapi.models.Game
import br.com.alura.gameapi.models.User
import br.com.alura.gameapi.services.ConsumerApi
import java.util.*

fun main() {
    val reader = Scanner(System.`in`)

    val user = User.createUser(reader)

    do {
        println("Digite um codigo de jogo para buscar:")
        val search = reader.nextLine()

        val searchApi = ConsumerApi().getGame(search)

        var myGame: Game? = null

        val result = runCatching {
            myGame = Game(
                searchApi.info.title,
                searchApi.info.thumb
            )
        }

        result.onFailure {
            println("Jogo inexistente. Tente outro id.")
        }

        result.onSuccess {
            println("Deseja inserir uma descrição personalizada? S/N")
            val option = reader.nextLine()
            if (option.equals("s", true)) {
                println("Insira a descricao personalizada para o jogo:")
                val description = reader.nextLine()
                myGame?.description = description
            } else {
                myGame?.description = myGame?.title
            }

            user.searchGames.add(myGame)
        }

        println("Deseja buscar um novo jogo? S/N")
        val response = reader.nextLine()
    } while (response.equals("s", true))

    println("Jogos buscados:")
    println(user.searchGames)

    println("\n Jogos ordenados por título: ")
    user.searchGames.sortBy {
        it?.title
    }

    user.searchGames.forEach {
        println("Título: " + it?.title)
    }

    val filteringGames = user.searchGames.filter {
        it?.title?.contains("batman", true) ?: false
    }

    println("\n Jogos filtrados: ")
    println(filteringGames)

    println("Deseja excluir algum jogo da lista original? S/N")
    val option = reader.nextLine()
    if (option.equals("s", true)) {
        println(user.searchGames)
        println("\nInforme a posição do jogo que deseja excluir: ")
        val posicao = reader.nextInt()
        user.searchGames.removeAt(posicao)
    }

    println("\n Lista atualizada:")
    println(user.searchGames)

    println("Busca finalizada com sucesso.")
}