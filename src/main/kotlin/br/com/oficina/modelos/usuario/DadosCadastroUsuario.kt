package br.com.oficina.modelos.usuario

import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo

data class DadosCadastroUsuario(
        val nome: String,
        val email: String,
        val cpf: String,
        val senha: String,
        val veiculos: MutableList<DadosCadastroVeiculo>? = null
)
