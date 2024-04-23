package br.com.oficina.modelos.usuario

import br.com.oficina.modelos.veiculo.Veiculo

data class DadosDetalhamentoUsuario(
    val nome: String,
    val email: String,
    val cpf: String,
    val veiculos: MutableList<Veiculo>
)
