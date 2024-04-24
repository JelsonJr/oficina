package br.com.oficina.controllers

import br.com.oficina.modelos.DadosCadastro
import br.com.oficina.services.UsuarioService
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
    fun visualizarPerfil() = "usuarios/index"

    @GetMapping("/cadastro")
    fun formularioDeCadastro(model: Model): String {
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
    fun cadastrar(@Valid @ModelAttribute dados: DadosCadastro, bindingResult: BindingResult, model: Model): String {
        if (bindingResult.hasErrors()) {
            model.addAttribute("dadosCadastro", dados)
            return "redirect:/login?cadastroSuccess=true"
        }

        this.service.cadastrar(dados)
        return "redirect:/login"
    }
}