package br.com.oficina.repositorys

import br.com.oficina.modelos.usuario.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetails

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByEmail(email: String) : Usuario
}