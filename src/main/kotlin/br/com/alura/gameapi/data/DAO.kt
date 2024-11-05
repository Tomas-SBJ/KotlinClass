package br.com.alura.gameapi.data

import javax.persistence.EntityManager

abstract class DAO <TModel, TEntity>(
    protected val manager: EntityManager,
    protected val entityType: Class<TEntity>) {
    abstract fun toEntity(model: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getList(): List<TModel> {
        val query = manager.createQuery("FROM ${entityType.simpleName}", entityType)

        return query.resultList.map {
                entity -> toModel(entity)
        }
    }

    open fun create(model: TModel) {
        val entity = toEntity(model)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun getById(id: Int): TModel {
        val query = manager.createQuery("FROM ${entityType.simpleName} e WHERE e.id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        return toModel(entity)
    }

    open fun deleteById(id: Int) {
        val query = manager.createQuery("FROM ${entityType.simpleName} e WHERE e.id=:id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}