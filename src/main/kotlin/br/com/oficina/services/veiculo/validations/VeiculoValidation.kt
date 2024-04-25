package br.com.oficina.services.veiculo.validations

import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo

interface VeiculoValidation {
    fun validar(dados: DadosCadastroVeiculo)
}