package br.com.oficina.services.usuario.validations

import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.repositorys.VeiculoRepository
import br.com.oficina.infra.errors.exceptions.CadastroInvalidoException
import org.springframework.stereotype.Service

@Service
class ValidaVeiculoJaCadastradoNoCadastroDeUsuario(
    val repository: VeiculoRepository
) : UsuarioValidation {

    override fun validar(dados: DadosCadastro) {
        val veiculoJaCadastrado = repository.findByPlaca(dados.placa)

        if(veiculoJaCadastrado != null) {
            throw CadastroInvalidoException("Veículo já cadastrado")
        }
    }
}