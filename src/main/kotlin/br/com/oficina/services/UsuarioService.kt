package br.com.oficina.services

import br.com.oficina.extensions.toUsuario
import br.com.oficina.extensions.toVeiculo
import br.com.oficina.modelos.DadosCadastro
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

    fun cadastrar(dados: DadosCadastro) {
        println(dados)
        val usuario = repository.save(dados.toUsuario(passwordEncoder))
        val veiculo = veiculoRepository.save(dados.toVeiculo(usuario))

        usuario.veiculos.add(veiculo)
        println(usuario)
    }
}