package br.com.alura.gameapi.principal

import br.com.alura.gameapi.services.ConsumerApi

fun main() {
    val consumerApi = ConsumerApi()

    val gameList = consumerApi.getGamesJson()
    println(gameList)
}