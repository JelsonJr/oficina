package br.com.oficina.extensions

import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import br.com.oficina.modelos.veiculo.Veiculo

fun DadosCadastroVeiculo.toModel(): Veiculo {
    return Veiculo(
        placa = this.placa,
        modelo = this.modelo,
        ano = this.ano,
    )
}