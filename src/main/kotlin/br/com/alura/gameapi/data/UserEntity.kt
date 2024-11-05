package br.com.alura.gameapi.data

import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val name: String = "name",
    val email: String = "email",
    val birthDate: String? = null,
    val username: String? = null,
)