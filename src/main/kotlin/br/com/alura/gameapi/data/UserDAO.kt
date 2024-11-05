package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.User
import br.com.alura.gameapi.utils.toEntity
import br.com.alura.gameapi.utils.toModel
import javax.persistence.EntityManager

class UserDAO(manager: EntityManager): DAO<User, UserEntity>(manager, UserEntity::class.java) {
    override fun toEntity(model: User): UserEntity {
        return model.toEntity()
    }

    override fun toModel(entity: UserEntity): User {
        return entity.toModel()
    }
}