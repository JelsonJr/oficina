package br.com.oficina.repositorys

import br.com.oficina.modelos.usuario.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {

    fun findByEmail(email: String) : Usuario
}