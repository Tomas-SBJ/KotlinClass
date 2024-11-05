package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.Rent
import br.com.alura.gameapi.utils.toEntity
import br.com.alura.gameapi.utils.toModel
import javax.persistence.EntityManager

class RentDAO(manager: EntityManager): DAO<Rent, RentEntity>(manager, RentEntity::class.java) {
    override fun toModel(entity: RentEntity): Rent {
        return Rent(entity.user.toModel(), entity.game.toModel(), entity.period)
            .apply {
                id = entity.id
            }
    }

    override fun toEntity(model: Rent): RentEntity {
        return RentEntity(model.user.toEntity(), model.game.toEntity(), model.period)
            .apply {
                rentValue = model.rentValue
                id = model.id
            }
    }
}