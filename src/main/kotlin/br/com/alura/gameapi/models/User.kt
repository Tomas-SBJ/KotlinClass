package br.com.alura.gameapi.models

import br.com.alura.gameapi.utils.transformerAge
import java.util.*
import kotlin.random.Random

data class User(var name: String,
                var email: String): Recommendation {
    var id = 0
    var birthDate: String? = null

    var username: String? = null
        set(value)  {
            field = value
            if (internalId.isNullOrBlank()) {
                createInternalId()
            }
        }

    var internalId: String? = null
        private set

    var plan: Plan = SinglePlan("BRONZE")

    val searchGames = mutableListOf<Game?>()
    val rentalGames = mutableListOf<Rent>()
    private val ratingList = mutableListOf<Int>()
    val recommendedGames = mutableListOf<Game>()

    override val average: Double
        get() = ratingList.average()

    override fun recommend(rating: Int) {
        if (rating < 1 || rating > 10) {
            println("Rating must be between 1 and 10")
            return
        }

        ratingList.add(rating)
    }

    fun recommendGame(game: Game, rating: Int) {
        game.recommend(rating)
        recommendedGames.add(game)
    }

    constructor(name: String, email: String, birthDate: String?, user: String?, id: Int = 0):
            this(name, email) {
        this.birthDate = birthDate
        this.username = user

        createInternalId()
    }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Name cannot is null or blank")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "User:\n" +
                "Id: $id\n" +
                "Name: $name\n" +
                "Email: $email\n" +
                "Birth date: $birthDate\n" +
                "Username: $username\n" +
                "InternalId: $internalId\n" +
                "Reputation: $average"
    }

    private fun createInternalId(): String {
        val randomNumber = Random.nextInt(10000)
        val tag = String.format("%04d", randomNumber)

        return "$randomNumber#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Invalid Email!")
        }
    }

    fun rentGame(game: Game,
                 period: Period): Rent {
        val rent = Rent(this, game, period)
        rentalGames.add(rent)

        return rent
    }

    fun filterMonthRent(month: Int): List<Game> {
        return rentalGames
            .filter { rent -> rent.period.initialDate.monthValue == month }
            .map { rent -> rent.game }
    }

    companion object {
        fun createUser(reader: Scanner): User {
            println("Boas vindas ao GameApi! Vamos fazer seu cadastro. Digite seu nome:")
            val name = reader.nextLine()
            println("Digite seu e-mail:")
            val email = reader.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = reader.nextLine()

            val user = User(name, email)

            if (option.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val birthDate = reader.nextLine()
                println("Digite seu nome de usuário:")
                val userName = reader.nextLine()

                user.username = userName
                user.birthDate = birthDate
            }

            println("Cadastro concluído com sucesso. Dados do usuario:")
            println(user)
            println("Idade do usuario: " + user.birthDate?.transformerAge())

            return user
        }
    }
}