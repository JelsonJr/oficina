package br.com.oficina.modelos.veiculo

import br.com.oficina.modelos.usuario.DadosCadastroUsuario

data class DadosCadastroVeiculo (
        val placa: String,
        val modelo: String,
        val ano: Int,
        val proprietario: DadosCadastroUsuario
)