package br.com.oficina.modelos.veiculo

import br.com.oficina.modelos.usuario.Usuario
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import java.time.LocalDateTime

@Entity
class Veiculo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        val placa: String = "",
        val modelo: String = "",
        val ano: Int = LocalDateTime.now().year,

        @ManyToOne
        var proprietario: Usuario? = null
) {}
