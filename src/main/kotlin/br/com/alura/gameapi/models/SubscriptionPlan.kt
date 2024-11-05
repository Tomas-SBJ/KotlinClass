package br.com.alura.gameapi.models

import java.math.BigDecimal
import java.math.RoundingMode

class SubscriptionPlan(
    type: String,
    val monthlyFee: BigDecimal,
    val includeGames: Int,
    val discountPercentage: BigDecimal,
    id: Int = 0): Plan(type, id) {

    override fun getValue(rent: Rent): BigDecimal {
        val totalMonthlyGames =
            rent.user.filterMonthRent(rent.period.initialDate.monthValue).size + 1

        if (totalMonthlyGames <= includeGames) {
            return BigDecimal.ZERO
        }

        var originValue = super.getValue(rent)

        if (rent.user.average > 8) {
            originValue -= originValue.multiply(discountPercentage)
        }

        return originValue.setScale(2, RoundingMode.HALF_EVEN)
    }

    override fun toString(): String {
        return "Subscription Plan\n" +
                "Type: $type\n" +
                "Id: $id\n" +
                "Monthly fee: $monthlyFee\n" +
                "Includes games: $includeGames\n" +
                "Discount percentage: $discountPercentage\n"
    }
}