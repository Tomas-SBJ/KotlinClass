package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.User
import javax.persistence.EntityManager

class UserDAO(val manager: EntityManager): DAO<User>() {
    override fun getList(): List<User> {
        val query = manager.createQuery("FROM UserEntity", UserEntity::class.java)
        return query.resultList.map {
            entity -> User(entity.name, entity.email, entity.birthDate, entity.username, entity.id)
        }
    }

    override fun create(user: User) {
        val entity = UserEntity(user.id, user.name, user.email, user.birthDate, user.username)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }
}