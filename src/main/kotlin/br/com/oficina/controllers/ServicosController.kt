package br.com.oficina.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/servicos")
class ServicosController {

    @GetMapping
    fun listarServicos() = "servico/index"
}