package br.com.oficina.services

import br.com.oficina.extensions.toModel
import br.com.oficina.modelos.usuario.DadosCadastroUsuario
import br.com.oficina.modelos.veiculo.Veiculo
import br.com.oficina.repositorys.UsuarioRepository
import br.com.oficina.repositorys.VeiculoRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    private val repository: UsuarioRepository,
    private val veiculoRepository: VeiculoRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun cadastrar(dadosUsuario: DadosCadastroUsuario, veiculo: Veiculo?) {
        val usuario = dadosUsuario.toModel(passwordEncoder)

        if (veiculo != null) {
            usuario.veiculos.add(veiculo)
        }

        val usuarioSalvo = repository.save(usuario)

        if (veiculo != null) {
            veiculo.proprietario = usuarioSalvo

            veiculoRepository.save(veiculo)
        }
    }
}