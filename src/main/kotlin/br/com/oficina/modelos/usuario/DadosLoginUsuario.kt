package br.com.oficina.modelos.usuario

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class DadosLoginUsuario(
    @Email
    @NotBlank
    val email: String,

    @NotBlank
    val senha: String
)
