package br.com.alura.gameapi.models

import java.time.LocalDate
import java.time.Period
import javax.persistence.Embeddable

@Embeddable
open class Period(
    val initialDate: LocalDate = LocalDate.now(),
    val finalDate: LocalDate = LocalDate.now().plusDays(7)) {
    val days = Period.between(initialDate, finalDate).days
}