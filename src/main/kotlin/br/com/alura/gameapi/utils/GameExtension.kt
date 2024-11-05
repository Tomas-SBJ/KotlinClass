package br.com.alura.gameapi.utils

import br.com.alura.gameapi.data.GameEntity
import br.com.alura.gameapi.models.Game
import br.com.alura.gameapi.models.InfoGameJson

fun InfoGameJson.toGame(): Game {
    return Game(this.titulo,
        this.capa,
        this.preco.toBigDecimal(),
        this.descricao)
}

fun Game.toEntity(): GameEntity {
    return GameEntity(this.id, this.title, this.thumb, this.price, this.description)
}

fun GameEntity.toModel(): Game {
    return Game(this.title, this.thumb, this.price, this.description, this.id)
}