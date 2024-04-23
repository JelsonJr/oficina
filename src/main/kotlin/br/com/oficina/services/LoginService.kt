package br.com.oficina.services

import br.com.oficina.modelos.usuario.Usuario
import br.com.oficina.repositorys.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class LoginService(
    private val repository: UsuarioRepository,
) {
    fun findByLogin(login: String): Usuario {
        return repository.findByEmail(login)
    }
}