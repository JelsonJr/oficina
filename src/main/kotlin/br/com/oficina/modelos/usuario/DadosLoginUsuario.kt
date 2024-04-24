package br.com.oficina.modelos.usuario

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class DadosLoginUsuario(
    @Email(message = "O campo deve estar no formato de email")
    @NotBlank(message = "O campo não deve estar vazio")
    val email: String,

    @NotBlank(message = "O campo não deve estar vazio")
    val senha: String
)
