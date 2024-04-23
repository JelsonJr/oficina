package br.com.oficina.extensions

import br.com.oficina.modelos.usuario.DadosCadastroUsuario
import br.com.oficina.modelos.usuario.Usuario
import org.springframework.security.crypto.password.PasswordEncoder

fun DadosCadastroUsuario.toModel(encoder: PasswordEncoder): Usuario {
    val telefone = this.telefone ?: ""

    return Usuario(
        nome = this.nome,
        email = this.email,
        cpf = this.cpf.replace("[.-]".toRegex(), ""),
        senha = encoder.encode(this.senha),
        telefone = telefone,
    )
}