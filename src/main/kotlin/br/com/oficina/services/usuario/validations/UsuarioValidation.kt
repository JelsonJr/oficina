package br.com.oficina.services.usuario.validations

import br.com.oficina.modelos.DadosCadastro

interface UsuarioValidation {
    fun validar(dados: DadosCadastro)
}