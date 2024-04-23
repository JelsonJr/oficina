package br.com.oficina.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/usuario")
class UsuarioController {

    @GetMapping
    fun visualizarPerfil() = "usuarios/index"

    @GetMapping("/cadastro")
    fun formularioDeCadastro() = "usuarios/cadastro"
}