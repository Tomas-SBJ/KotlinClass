package br.com.alura.gameapi.utils

import br.com.alura.gameapi.models.InfoUserJson
import br.com.alura.gameapi.models.User

fun InfoUserJson.toUser(): User {
    return User(this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}