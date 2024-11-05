package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.Plan
import br.com.alura.gameapi.utils.toEntity
import br.com.alura.gameapi.utils.toModel
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager): DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(model: Plan): PlanEntity {
        return model.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()
    }
}