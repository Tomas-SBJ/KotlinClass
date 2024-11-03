package br.com.alura.gameapi.services

import br.com.alura.gameapi.models.GameInfo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumerApi {
    fun getGame(id: String): GameInfo {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val infoGame = Gson().fromJson(json, GameInfo::class.java)

        return infoGame
    }
}