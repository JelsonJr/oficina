package br.com.oficina.controllers

import br.com.oficina.services.CookieService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/servicos")
class ServicosController {

    @GetMapping
    fun listarServicos(model: Model, request: HttpServletRequest): String {
        model.addAttribute("logado", CookieService.getCookie(request, "usuario_id"))

        return "servico/index"
    }
}