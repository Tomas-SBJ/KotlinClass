package br.com.alura.gameapi.models

data class Rent(
    val user: User,
    val game: Game,
    val period: Period) {
    val rentValue = user.plan.getValue(this)

    override fun toString(): String {
        return "Aluguel do jogo ${game.title} por ${user.name} pelo valor de R$$rentValue"
    }
}