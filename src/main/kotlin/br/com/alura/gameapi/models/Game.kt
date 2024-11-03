package br.com.alura.gameapi.models

class Game(val title: String,
           val thumb: String) {
    var description: String? = null

    override fun toString(): String {
        return "Title: $title, " +
               "Thumb: $thumb" +
               "Description: $description"
    }
}