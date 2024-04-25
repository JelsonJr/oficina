package br.com.oficina.services.usuario.validations

import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.repositorys.UsuarioRepository
import br.com.oficina.infra.errors.exceptions.CadastroInvalidoException
import org.springframework.stereotype.Service

@Service
class ValidaTelefoneJaCadastrado(
    private val repository: UsuarioRepository
) : UsuarioValidation{

    override fun validar(dados: DadosCadastro) {
        if(!dados.telefone.isNullOrBlank()) {
            val usuarioComTelefoneJaCadastrado = repository.findByTelefone(dados.telefone)

            if(usuarioComTelefoneJaCadastrado != null) {
                throw CadastroInvalidoException("Telefone já cadastrado por outro usuário")
            }
        }
    }
}