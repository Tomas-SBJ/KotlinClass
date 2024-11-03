package br.com.alura.gameapi.models

class Game(val title: String,
           val thumb: String) {
    var description: String? = null
    var price = 0.0

    constructor (title: String, thumb: String, price: Double, description: String?)
            : this(title, thumb) {
        this.price = price
        this.description = description
    }

    override fun toString(): String {
        return "Title: $title, " +
               "Thumb: $thumb, " +
               "Description: $description, " +
               "Price: $price"
    }
}