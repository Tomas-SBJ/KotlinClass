package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.Game
import javax.persistence.EntityManager

class GamesDAO(val manager: EntityManager): DAO<Game>() {
    override fun getList(): List<Game> {
        val query = manager.createQuery("FROM GameEntity", GameEntity::class.java)
        return query.resultList.map { entity ->
            Game(entity.title, entity.thumb, entity.price, entity.description, entity.id)
        }
    }

    override fun create(game: Game) {
        val entity = GameEntity(game.id, game.title, game.thumb, game.price, game.description)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}