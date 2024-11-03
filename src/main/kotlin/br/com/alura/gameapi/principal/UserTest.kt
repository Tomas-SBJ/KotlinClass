package br.com.alura.gameapi.principal

import br.com.alura.gameapi.models.Period
import br.com.alura.gameapi.services.ConsumerApi
import java.time.LocalDate

fun main() {
    val consumerApi = ConsumerApi()

    val userList = consumerApi.getUser()
    val gameList = consumerApi.getGamesJson()

    val user = userList[2]
    val game = gameList[6]

    println(user)
    println(game)

    val period = Period(LocalDate.now(), LocalDate.now().plusDays(7))

    val rent = user.rentGame(game, period)
    println(rent)
}