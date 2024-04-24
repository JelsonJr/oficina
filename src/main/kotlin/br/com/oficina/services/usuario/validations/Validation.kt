package br.com.oficina.services.usuario.validations

import br.com.oficina.modelos.DadosCadastro

interface Validation {
    fun validar(dados: DadosCadastro)
}