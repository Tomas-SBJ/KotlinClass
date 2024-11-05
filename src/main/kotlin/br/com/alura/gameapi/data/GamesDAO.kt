package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.Game
import br.com.alura.gameapi.utils.toEntity
import br.com.alura.gameapi.utils.toModel
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager): DAO<Game, GameEntity>(manager, GameEntity::class.java) {
    override fun toEntity(model: Game): GameEntity {
        return model.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }
}