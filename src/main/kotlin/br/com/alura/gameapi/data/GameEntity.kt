package br.com.alura.gameapi.data

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "games")
open class GameEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val title: String = "Game title",
    val thumb: String = "Game thumb",
    val price: BigDecimal = BigDecimal.ZERO,
    val description: String? = null
)
