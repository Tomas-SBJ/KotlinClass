package br.com.alura.gameapi.models

import br.com.alura.gameapi.utils.transformerAge
import java.util.Scanner
import kotlin.random.Random

data class User(var name: String,
                var email: String) {
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

    val searchGames = mutableListOf<Game?>()

    constructor(name: String, email: String, birthDate: String, user: String):
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
        return "User(name='$name', email='$email', birthDate='$birthDate', username='$username', internalId='$internalId')"
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

    companion object {
        fun createUser(reader: Scanner): User {
            println("Boas vindas ao GameApi! Vamos fazer seu cadastro. Digite seu nome:")
            val name = reader.nextLine()
            println("Digite seu e-mail:")
            val email = reader.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = reader.nextLine()

            var user = User(name, email)

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