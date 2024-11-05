package br.com.alura.gameapi.data

import br.com.alura.gameapi.models.Period
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "rent")
open class RentEntity(
    @ManyToOne
    val user: UserEntity = UserEntity(),
    @ManyToOne
    val game: GameEntity = GameEntity(),
    @Embedded
    val period: Period = Period()
) {
    var rentValue = BigDecimal.ZERO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id = 0
}