package br.com.oficina.extensions

import br.com.oficina.modelos.usuario.Usuario
import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import br.com.oficina.modelos.veiculo.Veiculo
import java.util.*

fun DadosCadastroVeiculo.toVeiculo(proprietario: Usuario): Veiculo {
    return Veiculo(
        proprietario = proprietario,
        ano = this.ano,
        modelo = this.modelo,
        placa = this.placa.uppercase(Locale.getDefault())
    )
}