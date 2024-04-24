package br.com.oficina.controllers

import br.com.oficina.services.CookieService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping
    fun home(request: HttpServletRequest, model: Model): String {
        model.addAttribute("logado", CookieService.getCookie(request, "usuario_id"))

        return "index"
    }

    @GetMapping("/TESTE")
    fun teste() = "index"
}