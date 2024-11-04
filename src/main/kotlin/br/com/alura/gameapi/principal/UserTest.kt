package br.com.alura.gameapi.principal

import br.com.alura.gameapi.services.ConsumerApi
import com.google.gson.GsonBuilder
import java.io.File

fun main() {
    val consumerApi = ConsumerApi()

    val userList = consumerApi.getUser()
    val gameList = consumerApi.getGamesJson()

    val gamerCaroline = userList.get(3)
    val jogoResidentVillage = gameList.get(10)
    val jogoSpider = gameList.get(13)
    val jogoTheLastOfUs = gameList.get(2)
    val jogoDandara = gameList.get(5)
    val jogoAssassins = gameList.get(4)
    val jogoCyber = gameList.get(6)
    val jogoGod = gameList.get(7)
    val jogoSkyrim = gameList.get(18)

    gamerCaroline.recommendGame(jogoResidentVillage, 7)
    gamerCaroline.recommendGame(jogoTheLastOfUs, 10)
    gamerCaroline.recommendGame(jogoAssassins, 8)
    gamerCaroline.recommendGame(jogoCyber, 7)
    gamerCaroline.recommendGame(jogoGod, 10)
    gamerCaroline.recommendGame(jogoDandara, 8)
    gamerCaroline.recommendGame(jogoSkyrim, 8)
    gamerCaroline.recommendGame(jogoSpider, 6)

    gamerCaroline.recommend(6)
    gamerCaroline.recommend(9)

    println(gamerCaroline)

    val gsonBuilder = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serializer = gsonBuilder.toJson(gamerCaroline.recommendedGames)

    val data = File("recommendedGames-${gamerCaroline.name}.json")
    data.writeText(serializer)
}