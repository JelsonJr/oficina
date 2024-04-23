package br.com.oficina.modelos.usuario

import br.com.oficina.modelos.veiculo.Veiculo
import jakarta.persistence.*

@Entity
class Usuario(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        val nome: String = "",
        val email: String = "",
        val cpf: String = "",
        val senha: String = "",

        @OneToMany
        val veiculos: MutableList<Veiculo> = mutableListOf<Veiculo>()
) {}
