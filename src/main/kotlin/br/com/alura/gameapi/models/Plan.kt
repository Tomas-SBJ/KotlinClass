package br.com.alura.gameapi.models

import java.math.BigDecimal

sealed class Plan(val type: String, var id: Int = 0) {
    open fun getValue(rent: Rent): BigDecimal {
        return rent.game.price * rent.period.days.toBigDecimal()
    }
}