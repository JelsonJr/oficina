package br.com.oficina.controllers

import br.com.oficina.modelos.usuario.DadosLoginUsuario
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun login() = "login/index"

    @PostMapping("/login")
    fun logar(dados: DadosLoginUsuario): String {
        println(dados)
        return "redirect:/"
    }
}
