package br.com.oficina.infra.security

import br.com.oficina.modelos.usuario.Usuario
import br.com.oficina.services.CookieService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.stereotype.Component


@Component
class CustomAuthenticationSuccessHandler : SimpleUrlAuthenticationSuccessHandler() {

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        val usuario = authentication.principal as Usuario
        CookieService.setCookie(response, "usuario_id",  usuario.id.toString(), 60 * 60)

        response.sendRedirect("/")
    }
}