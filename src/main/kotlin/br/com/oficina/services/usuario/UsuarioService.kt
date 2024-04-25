package br.com.oficina.services.usuario

import br.com.oficina.extensions.toUsuario
import br.com.oficina.extensions.toVeiculo
import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.repositorys.UsuarioRepository
import br.com.oficina.repositorys.VeiculoRepository
import br.com.oficina.services.usuario.validations.UsuarioValidation
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val veiculoRepository: VeiculoRepository,
    private val passwordEncoder: PasswordEncoder,
    private val validacoes: List<UsuarioValidation>
) {

    fun cadastrar(dados: DadosCadastro) {
        validacoes.forEach { it.validar(dados) }

        val usuario = repository.save(dados.toUsuario(passwordEncoder))
        val veiculo = veiculoRepository.save(dados.toVeiculo(usuario))

        usuario.veiculos.add(veiculo)
    }
}