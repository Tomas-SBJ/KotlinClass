package br.com.alura.gameapi.utils

import br.com.alura.gameapi.data.UserEntity
import br.com.alura.gameapi.models.InfoUserJson
import br.com.alura.gameapi.models.User

fun InfoUserJson.toUser(): User {
    return User(this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}

fun User.toEntity(): UserEntity {
    return UserEntity(this.id, this.name, this.email, this.birthDate, this.username, this.plan.toEntity())
}

fun UserEntity.toModel(): User {
    return User(this.name, this.email, this.birthDate, this.email, this.id)
}