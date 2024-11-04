package br.com.alura.gameapi.models

import com.google.gson.annotations.Expose
import java.math.BigDecimal

data class Game(
    @Expose val title: String,
    @Expose val thumb: String): Recommendation {
    var description: String? = null
    var price = BigDecimal.ZERO
    private val ratingList = mutableListOf<Int>()

    override val average: Double
        get() = ratingList.average()

    override fun recommend(rating: Int) {
        if (rating < 0 || rating > 10) {
            println("Rating must be between 1 and 10")
            return
        }

        ratingList.add(rating)
    }

    constructor (title: String, thumb: String, price: BigDecimal, description: String?)
            : this(title, thumb) {
        this.price = price
        this.description = description
    }

    override fun toString(): String {
        return "Title: $title\n " +
                "Thumb: $thumb\n " +
                "Description: $description\n " +
                "Price: $price\n " +
                "Reputation: $average"
    }
}