package br.com.oficina.modelos.servico

import br.com.oficina.modelos.usuario.Usuario
import br.com.oficina.modelos.veiculo.Veiculo
import java.math.BigDecimal

data class DadosNovoServico(
        val proprieario: Usuario,
        val veiculo: Veiculo,
        val acao: String,
        val valor: BigDecimal,
        val mecanico: String
)
