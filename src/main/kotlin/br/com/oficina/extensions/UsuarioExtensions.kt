package br.com.oficina.extensions

import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.modelos.usuario.DadosDetalhamentoUsuario
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

fun Usuario.toDadosDetalhamento(): DadosDetalhamentoUsuario {
    println(this.veiculos)
    return DadosDetalhamentoUsuario(
        this.nome,
        this.email,
        formatarCPF(this.cpf),
        formatarTelefone(this.telefone),
        this.veiculos
    )
}

private fun formatarCPF(cpf: String): String {
    val cpfFormatado = cpf.replace(Regex("(\\d{3})(\\d{3})(\\d{3})(\\d{2})"), "$1.$2.$3-$4")

    val cpfObscurecido = cpfFormatado.replaceRange(1, 2, "*")
        .replaceRange(5, 7, "**")
        .replaceRange(9, 11, "**")
        .replaceRange(12, 13, "*")

    return cpfObscurecido
}

private fun formatarTelefone(telefone: String?): String {
    if (telefone.isNullOrBlank()) {
        return ""
    }

    val telefoneNumerico = telefone.replace(Regex("[^0-9]"), "")

    return "(${telefoneNumerico.substring(0, 2)}) ${telefoneNumerico.substring(2, 7)}-${telefoneNumerico.substring(7)}"
}