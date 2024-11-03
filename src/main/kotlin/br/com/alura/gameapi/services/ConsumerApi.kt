package br.com.alura.gameapi.services

import br.com.alura.gameapi.models.*
import br.com.alura.gameapi.utils.toGame
import br.com.alura.gameapi.utils.toUser
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumerApi {
    fun getGame(id: String): GameInfo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"
        val json = consumerData(url)

        val infoGame = Gson().fromJson(json, GameInfo::class.java)

        return infoGame
    }

    fun getUser(): List<User> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"
        val json = consumerData(url)

        val listTpe = object : TypeToken<List<InfoUserJson>>()  {}.type
        val userList: List<InfoUserJson> = Gson().fromJson(json, listTpe)

        val convertedUserList = userList.map {
            infoUserJson -> infoUserJson.toUser()
        }

        return convertedUserList
    }

    fun getGamesJson(): List<Game> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = consumerData(url)

        val infoGameList = object : TypeToken<List<InfoGameJson>>() {}.type

        val gamesList: List<InfoGameJson> = Gson().fromJson(json, infoGameList)

        val convertedGamesList = gamesList.map {
            infoGameJson -> infoGameJson.toGame()
        }

        return convertedGamesList
    }

    private fun consumerData(url: String): String {
        val client = HttpClient.newHttpClient()

        val request = HttpRequest
            .newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client.send(request, BodyHandlers.ofString())

        return response.body()
    }
}