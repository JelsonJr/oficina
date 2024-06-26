package br.com.oficina.controllers

import br.com.oficina.infra.errors.exceptions.CadastroInvalidoException
import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.services.CookieService
import br.com.oficina.services.usuario.UsuarioService
import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/usuario")
class UsuarioController(
    private val service: UsuarioService
) {

    @GetMapping
    fun visualizarPerfil(model: Model, request: HttpServletRequest): String {
        val cookie = CookieService.getCookie(request, "usuario_id") ?: return "redirect:/login?cookieExpired=true"
        model.addAttribute("logado", cookie)

        val usuario = this.service.getUsuario(cookie.toLong())
        model.addAttribute("usuario", usuario)

        return "usuario/index"
    }

    @GetMapping("/cadastro")
    fun formularioDeCadastro(model: Model, request: HttpServletRequest): String {
        val cookie = CookieService.getCookie(request, "usuario_id")

        if (cookie != null) {
            return "redirect:/error"
        }

        model.addAttribute(
            "dadosCadastro", DadosCadastro(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                0
            )
        )

        return "usuario/cadastro"
    }

    @PostMapping("/cadastro")
    fun cadastrar(
        @Valid @ModelAttribute dados: DadosCadastro,
        bindingResult: BindingResult,
        model: Model,
        request: HttpServletRequest
    ): String {
        val cookie = CookieService.getCookie(request, "usuario_id")

        if (cookie != null) {
            return "redirect:/error"
        }

        if (bindingResult.hasErrors()) {
            model.addAttribute("dadosCadastro", dados)
            return "usuario/cadastro"
        }

        try {
            this.service.cadastrar(dados)
        } catch (ex: CadastroInvalidoException) {
            model.addAttribute("erroDeCadastro", ex.message)
            return "usuario/cadastro"
        }

        return "redirect:/login?cadastroSuccess=true"
    }
}