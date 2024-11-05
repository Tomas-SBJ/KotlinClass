package br.com.alura.gameapi.utils

import br.com.alura.gameapi.data.PlanEntity
import br.com.alura.gameapi.data.SinglePlanEntity
import br.com.alura.gameapi.data.SubscriptionPlanEntity
import br.com.alura.gameapi.models.Plan
import br.com.alura.gameapi.models.SinglePlan
import br.com.alura.gameapi.models.SubscriptionPlan

fun Plan.toEntity(): PlanEntity {
    if (this is SubscriptionPlan) {
        return SubscriptionPlanEntity(this.type, this.monthlyFee, this.includeGames, this.discountPercentage, this.id)
    }
    return SinglePlanEntity(this.type, this.id)
}

fun PlanEntity.toModel(): Plan {
    if(this is SubscriptionPlanEntity) {
        SubscriptionPlan(this.type, this.monthlyFee, this.includeGames, this.discountPercentage, this.id)
    }
    return SinglePlan(this.type, this.id)
}