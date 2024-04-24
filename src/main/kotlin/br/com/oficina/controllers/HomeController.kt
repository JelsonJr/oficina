package br.com.oficina.controllers

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.util.WebUtils

@Controller
@RequestMapping("/")
class HomeController {

    @GetMapping
    fun home(request: HttpServletRequest, model: Model): String {
        val cookie = WebUtils.getCookie(request, "JSESSIONID")


        if (cookie != null && cookie.value != null) {
            println("cookie ${cookie.value} ${cookie.maxAge} ${cookie.name} ${cookie.path}")
            model.addAttribute("logado", "cookie");
        }

        return "index"
    }
}