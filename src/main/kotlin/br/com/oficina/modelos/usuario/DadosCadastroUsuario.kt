package br.com.oficina.modelos.usuario

import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class DadosCadastroUsuario(
        @NotBlank
        @Size(min = 5)
        val nome: String,

        @NotBlank
        @Email
        val email: String,

        @NotBlank
        val cpf: String,

        @NotBlank
        @Size(min = 8)
        val senha: String,

        val telefone: String? = null,
        val veiculos: MutableList<DadosCadastroVeiculo>? = null
)
