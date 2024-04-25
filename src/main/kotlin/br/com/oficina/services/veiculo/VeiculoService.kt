package br.com.oficina.services.veiculo

import br.com.oficina.extensions.toVeiculo
import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import br.com.oficina.repositorys.UsuarioRepository
import br.com.oficina.repositorys.VeiculoRepository
import br.com.oficina.services.veiculo.validations.VeiculoValidation
import org.springframework.stereotype.Service

@Service
class VeiculoService(
    private val repository: VeiculoRepository,
    private val usuarioRepository: UsuarioRepository,
    private val validacoes: List<VeiculoValidation>

) {

    fun cadastrar(dadosCadastroVeiculo: DadosCadastroVeiculo, idUsuario: Long) {
        validacoes.forEach { it.validar(dadosCadastroVeiculo) }

        val proprietario = usuarioRepository.getReferenceById(idUsuario)
        val veiculo = dadosCadastroVeiculo.toVeiculo(proprietario)

        val veiculoCadastrado = repository.save(veiculo)

        proprietario.veiculos.add(veiculoCadastrado)
        usuarioRepository.save(proprietario)
    }
}
