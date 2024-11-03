package br.com.alura.gameapi.models

import java.time.LocalDate
import java.time.Period

data class Period(
    val initialDate: LocalDate,
    val finalDate: LocalDate) {
    val days = Period.between(initialDate, finalDate).days
}