package br.com.alura.gameapi.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun String.transformerAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    var idade = 0
    val birthDate = LocalDate.parse(this, formatter)
    val today = LocalDate.now()
    idade = Period.between(birthDate, today).years

    return idade
}