package br.com.alura.gameapi.models

import java.math.BigDecimal
import java.math.RoundingMode

class SinglePlan(
    type: String,
    id: Int = 0): Plan(type, id) {

    override fun getValue(rent: Rent): BigDecimal {
        var originValue = super.getValue(rent)

        if (rent.user.average > 8) {
            originValue -= originValue.multiply(BigDecimal(0.1))
        }

        return originValue.setScale(2, RoundingMode.HALF_UP)
    }

    override fun toString(): String {
        return "Singles Plan\n" +
                "Type: $type\n" +
                "Id: $id\n"
    }
}