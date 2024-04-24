package br.com.oficina.extensions

import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.modelos.usuario.Usuario
import br.com.oficina.modelos.veiculo.Veiculo
import org.springframework.security.crypto.password.PasswordEncoder


fun DadosCadastro.toUsuario(passwordEncoder: PasswordEncoder): Usuario {
    val telefone = this.telefone ?: ""

    return Usuario(
        nome = this.nome,
        email = this.email,
        cpf = this.cpf.replace("[.-]".toRegex(), ""),
        senha = passwordEncoder.encode(this.senha),
        telefone = telefone,
    )
}

fun DadosCadastro.toVeiculo(proprietario: Usuario): Veiculo {
    return Veiculo(
        placa = this.placa,
        modelo = this.modelo,
        ano = this.ano,
        proprietario = proprietario
    )
}