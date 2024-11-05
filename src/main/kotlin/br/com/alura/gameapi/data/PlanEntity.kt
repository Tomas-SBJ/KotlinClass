package br.com.alura.gameapi.data

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PlanType", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    val type: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
) {
    constructor() : this(type = "")
}

@Entity
@DiscriminatorValue("Single")
open class SinglePlanEntity(
    type: String = "Single Plan",
    id: Int = 0
): PlanEntity(type, id)

@Entity
@DiscriminatorValue("Subscription")
open class SubscriptionPlanEntity(
    type: String = "Subscription Plan",
    val monthlyFee: BigDecimal = BigDecimal.ZERO,
    val includeGames: Int = 0,
    val discountPercentage: BigDecimal = BigDecimal.ZERO,
    id: Int = 0
): PlanEntity(type, id)