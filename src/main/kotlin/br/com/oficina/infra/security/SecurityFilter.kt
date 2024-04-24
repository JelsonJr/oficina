package br.com.oficina.infra.security

import br.com.oficina.services.CookieService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.util.AntPathMatcher
import org.springframework.web.filter.OncePerRequestFilter

@Component
class SecurityFilter : OncePerRequestFilter() {

    private val antPathMatcher = AntPathMatcher()

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        filterChain.doFilter(request, response)
    }

    private fun isAuthenticatedRoute(request: HttpServletRequest): Boolean {
        val path = request.requestURI
        val publicRoutes = listOf(
            "/",
            "/servicos",
            "/login",
            "/logout",
            "/usuario/cadastro",
            "/error",
            "/css/**",
            "/js/**",
            "/fonts/**",
            "/images/**",
            "/*.png",
            "/*.ico",
            "/*.jpg"
        )
        return !publicRoutes.any { antPathMatcher.match(it, path) }
    }
}
