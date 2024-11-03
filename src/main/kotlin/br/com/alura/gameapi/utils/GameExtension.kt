package br.com.alura.gameapi.utils

import br.com.alura.gameapi.models.Game
import br.com.alura.gameapi.models.InfoGameJson

fun InfoGameJson.toGame(): Game {
    return Game(this.titulo,
        this.capa,
        this.preco,
        this.descricao)
}