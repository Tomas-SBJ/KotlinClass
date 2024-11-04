package br.com.alura.gameapi.models

interface Recommendation {
    val average: Double

    fun recommend(rating: Int)
}