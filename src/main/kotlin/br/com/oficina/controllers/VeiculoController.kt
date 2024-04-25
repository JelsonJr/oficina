package br.com.oficina.controllers

import br.com.oficina.modelos.veiculo.DadosCadastroVeiculo
import br.com.oficina.services.CookieService
import br.com.oficina.infra.errors.exceptions.CadastroInvalidoException
import br.com.oficina.services.veiculo.VeiculoService
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
@RequestMapping("/veiculo")
class VeiculoController(
    private val service: VeiculoService
) {

    @GetMapping("/cadastro")
    fun formularioDeCadastro(model: Model, request: HttpServletRequest): String {
        val cookie = CookieService.getCookie(request, "usuario_id") ?: return "redirect:/login?cookieExpired=true"

        model.addAttribute("logado", cookie)
        model.addAttribute("dadosCadastroVeiculo", DadosCadastroVeiculo("", "", 0))

        return "veiculo/cadastro"
    }

    @PostMapping("/cadastro")
    fun cadastrar(
        @Valid @ModelAttribute dadosCadastro: DadosCadastroVeiculo,
        bindingResult: BindingResult,
        model: Model,
        request: HttpServletRequest
    ): String {
        val cookie = CookieService.getCookie(request, "usuario_id") ?: return "redirect:/login?cookieExpired=true"
        model.addAttribute("logado", cookie)

        if (bindingResult.hasErrors()) {
            model.addAttribute("dadosCadastroVeiculo", dadosCadastro)
            return "veiculo/cadastro"
        }

        try {
            this.service.cadastrar(dadosCadastro, cookie.toLong())
        } catch (ex: CadastroInvalidoException) {
            model.addAttribute("erroDeCadastro", ex.message)
            return "veiculo/cadastro"
        }

        return "redirect:/"
    }
}