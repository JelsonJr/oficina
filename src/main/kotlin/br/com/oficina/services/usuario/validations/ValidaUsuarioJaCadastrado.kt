package br.com.oficina.services.usuario.validations

import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.repositorys.UsuarioRepository
import br.com.oficina.services.usuario.validations.exceptions.CadastroInvalidoException
import org.springframework.stereotype.Service

@Service
class ValidaUsuarioJaCadastrado(val repository: UsuarioRepository) : Validation {

    override fun validar(dados: DadosCadastro) {
        val usuarioComMesmoEmailJaCadastrado = repository.findByEmail(dados.email)

        if(usuarioComMesmoEmailJaCadastrado != null) {
            throw CadastroInvalidoException("Email já cadastrado")
        }

        val usuarioComMesmoCPFJaCadastrado = repository.findByCpf(dados.cpf.replace("[.-]".toRegex(), ""))

        if(usuarioComMesmoCPFJaCadastrado != null) {
            throw CadastroInvalidoException("Usuario já cadastrado")
        }
    }
}