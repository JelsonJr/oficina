package br.com.oficina.services.veiculo.validations

import br.com.oficina.infra.errors.exceptions.CadastroInvalidoException
import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import br.com.oficina.repositorys.VeiculoRepository
import org.springframework.stereotype.Service

@Service
class ValidaVeiculoJaCadastradoNoCadastroDeVeiculo(
    private val repository: VeiculoRepository,
) : VeiculoValidation {

    override fun validar(dados: DadosCadastroVeiculo) {
        val veiculoJaCadastrado = repository.findByPlaca(dados.placa)

        if(veiculoJaCadastrado != null) {
            throw CadastroInvalidoException("Veículo já cadastrado")
        }
    }
}