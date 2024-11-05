package br.com.alura.gameapi.principal

import br.com.alura.gameapi.data.Base
import br.com.alura.gameapi.data.GamesDAO
import br.com.alura.gameapi.models.Game

fun main() {
    val manager = Base.getEntityManager()
    val gamesDAO = GamesDAO(manager)

    val gameList: List<Game> = gamesDAO.getGames()
    println(gameList)

    manager.close()
}