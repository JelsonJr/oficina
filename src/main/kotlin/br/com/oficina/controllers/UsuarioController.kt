package br.com.oficina.controllers

import br.com.oficina.extensions.toModel
import br.com.oficina.modelos.usuario.DadosCadastroUsuario
import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import br.com.oficina.services.UsuarioService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/usuario")
class UsuarioController(
    private val service: UsuarioService
) {

    @GetMapping
    fun visualizarPerfil() = "usuarios/index"

    @GetMapping("/cadastro")
    fun formularioDeCadastro() = "usuario/cadastro"

    @PostMapping("/cadastro")
    fun cadastrar(dadosUsuario: DadosCadastroUsuario, dadosVeiculo: DadosCadastroVeiculo): String {
        this.service.cadastrar(dadosUsuario, dadosVeiculo.toModel())

        return "redirect:/"
    }
}