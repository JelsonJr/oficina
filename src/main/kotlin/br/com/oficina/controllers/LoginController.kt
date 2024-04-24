package br.com.oficina.controllers

import br.com.oficina.modelos.usuario.DadosLoginUsuario
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class LoginController {

    @GetMapping("/login")
    fun login(
        @RequestParam(name = "loginRequired", required = false) loginRequired: Boolean,
        @RequestParam(name = "loginError", required = false) loginError: Boolean,
        @RequestParam(name = "logoutSuccess", required = false) logoutSuccess: Boolean,
        @RequestParam(name = "cadastroSuccess", required = false) cadastroSuccess: Boolean,
        @RequestParam(name = "cookieExpired", required = false) cookieExpired: Boolean,
        model: Model
    ): String {
        model.addAttribute("dadosLogin", DadosLoginUsuario("", ""))

        if (loginRequired) {
            println("Login required - LoginController")
            model.addAttribute("loginRequired", "É necessário estar logado para acessar esse recurso.")
        }

        if (loginError) {
            println("Login error - LoginController")
            model.addAttribute("loginError", "Login inválido, por favor tente novamente.")
        }

        if (cookieExpired) {
            println("Cookie Expired - LoginController")
            model.addAttribute("cookieExpired", "Tempo de acesso expirado, por favor, realize o login novamente.")
        }

        if (logoutSuccess) {
            println("Log out success - LoginController")
            model.addAttribute("logoutSuccess", "Log out realizado com sucesso.")
        }

        if (cadastroSuccess) {
            println("Log out success - LoginController")
            model.addAttribute("cadastroSuccess", "Cadastro realizado com sucesso! Insira suas informações para realizar o log in.")
        }

        return "login/index"
    }
}
