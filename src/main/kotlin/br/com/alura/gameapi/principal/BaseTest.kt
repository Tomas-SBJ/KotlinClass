package br.com.alura.gameapi.principal

import br.com.alura.gameapi.data.Base
import br.com.alura.gameapi.data.GamesDAO

fun main() {
    val manager = Base.getEntityManager()
    val gamesDAO = GamesDAO(manager)
    manager.close()
}