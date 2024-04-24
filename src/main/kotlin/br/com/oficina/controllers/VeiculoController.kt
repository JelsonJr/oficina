package br.com.oficina.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/veiculo")
class VeiculoController {

    @GetMapping("/cadastrar")
    fun cadastroDeVeiculo() : String {}

    @PostMapping("/cadastrar")
    fun cadastrar() : String {}
}